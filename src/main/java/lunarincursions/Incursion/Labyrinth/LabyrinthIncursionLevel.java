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

    public LabyrinthIncursionLevel(LevelIdentifier levelIdentifier, int width, int height, WorldEntity worldEntity) {
        super(levelIdentifier, width, height, worldEntity);
    }

    public LabyrinthIncursionLevel(LevelIdentifier identifier, BiomeMissionIncursionData incursion, WorldEntity worldEntity) {
        super(identifier, 300, 300, incursion, worldEntity);
        this.biome = BiomeRegistry.getBiome("labyrinthbiome");
        this.isCave = true;
        this.generateLevel(incursion);
    }

    public void generateLevel(BiomeMissionIncursionData incursionData) {
        LabyrinthMazeGenerator maze = new LabyrinthMazeGenerator(200, 200, true, 10); // Start at center
        maze.printMaze();

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
