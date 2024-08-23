package lunarincursions.Incursion.Labyrinth;

import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.WorldEntity;
import necesse.level.maps.IncursionLevel;
import necesse.level.maps.incursion.BiomeMissionIncursionData;
import necesse.level.maps.incursion.IncursionBiome;

public class LabyrinthIncursionLevel extends IncursionLevel {

    private final LabyrinthMazeGenerator maze;

    public LabyrinthIncursionLevel(LevelIdentifier levelIdentifier, int width, int height, WorldEntity worldEntity, LabyrinthMazeGenerator maze) {
        super(levelIdentifier, width, height, worldEntity);
        this.maze = maze;
    }

    public LabyrinthIncursionLevel(LevelIdentifier identifier, BiomeMissionIncursionData incursion, WorldEntity worldEntity) {
        super(identifier, 300, 300, incursion, worldEntity);
        this.biome = BiomeRegistry.getBiome("labyrinthbiome");
        this.isCave = true;
        this.maze = new LabyrinthMazeGenerator(300, 300, true, 2); // 20x20 maze with a center-started room of size 5x5
        this.generateLevel(incursion);
    }

    public void generateLevel(BiomeMissionIncursionData incursionData) {

        GameRandom random = new GameRandom(this.getSeed());

        int cryptAshID = TileRegistry.getTileID("cryptash");
        for(int tileX = 0; tileX < this.width; ++tileX) {
            for(int tileY = 0; tileY < this.height; ++tileY) {
                this.setTile(tileX, tileY, cryptAshID);
            }
        }
        IncursionBiome.generateEntrance(this, random, this.width / 2, this.height / 2, 30, cryptAshID, "cryptpath", (String)null, "cryptcolumn");
    }
}
