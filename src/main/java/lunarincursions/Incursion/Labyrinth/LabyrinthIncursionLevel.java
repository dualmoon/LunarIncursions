package lunarincursions.Incursion.Labyrinth;

import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.WorldEntity;
import necesse.level.maps.IncursionLevel;
import necesse.level.maps.incursion.IncursionBiome;

public class LabyrinthIncursionLevel extends IncursionLevel {
    // future
    private static final int levelWidth = 300;
    private static final int levelHeight = 300;

    public LabyrinthIncursionLevel(LevelIdentifier identifier, WorldEntity worldEntity) {
        super(identifier, levelWidth, levelHeight, worldEntity);
        this.biome = BiomeRegistry.getBiome("labyrinthbiome");
        this.isCave = true;
        this.generateLevel();
    }

    public void generateLevel() {
        LabyrinthMazeGenerator maze = new LabyrinthMazeGenerator(this.width, this.height, true);
        GameRandom random = new GameRandom(this.getSeed());
        int cryptAshID = TileRegistry.getTileID("cryptash");
        int deepRockID = TileRegistry.getTileID("deeprocktile");
        for(int tileX = 0; tileX < this.width; ++tileX) {
            for(int tileY = 0; tileY < this.height; ++tileY) {
                this.setTile(tileX, tileY, (maze.getTile(tileX, tileY) == 0 ? cryptAshID : deepRockID));
            }
        }
        IncursionBiome.generateEntrance(this, random, this.width / 2, this.height / 2, 30, cryptAshID, "cryptpath", null, "cryptcolumn");
    }
}
