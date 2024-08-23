package lunarincursions.Incursion.TestArena1;

import necesse.engine.GameEvents;
import necesse.engine.events.worldGeneration.*;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.engine.util.LevelIdentifier;
import necesse.engine.world.WorldEntity;
import necesse.level.maps.IncursionLevel;
import necesse.level.maps.generationModules.CaveGeneration;
import necesse.level.maps.generationModules.GenerationTools;
import necesse.level.maps.generationModules.PresetGeneration;
import necesse.level.maps.incursion.BiomeExtractionIncursionData;
import necesse.level.maps.incursion.BiomeMissionIncursionData;
import necesse.level.maps.incursion.IncursionBiome;

public class TestArena1IncursionLevel extends IncursionLevel {

    public TestArena1IncursionLevel(LevelIdentifier levelIdentifier, int width, int height, WorldEntity worldEntity) {
        super(levelIdentifier, width, height, worldEntity);
    }

    public TestArena1IncursionLevel(LevelIdentifier identifier, BiomeMissionIncursionData incursion, WorldEntity worldEntity) {
        super(identifier, 300, 300, incursion, worldEntity);
        this.biome = BiomeRegistry.getBiome("testarena1biome");
        this.isCave = true;
        this.generateLevel(incursion);
    }

    public void generateLevel(BiomeMissionIncursionData incursionData) {

    }
    /*
    public void generateLevel(BiomeMissionIncursionData incursionData) {
        CaveGeneration cg = new CaveGeneration(this, "deeprocktile", "deeprock");
        cg.random.setSeed((long)incursionData.getUniqueID());
        GameEvents.triggerEvent(new GenerateCaveLayoutEvent(this, cg), (e) -> {
            cg.generateLevel(0.38F, 4, 3, 6);
        });
        GameEvents.triggerEvent(new GeneratedCaveLayoutEvent(this, cg));
        GameEvents.triggerEvent(new GenerateCaveMiniBiomesEvent(this, cg), (e) -> {
            GenerationTools.generateRandomSmoothTileVeins(this, cg.random, 0.09F, 2, 7.0F, 20.0F, 3.0F, 8.0F, TileRegistry.getTileID("lavatile"), 1.0F, true);
            this.liquidManager.calculateShores();
            cg.generateRandomSingleRocks(ObjectRegistry.getObjectID("deepcaverock"), 0.005F);
            cg.generateRandomSingleRocks(ObjectRegistry.getObjectID("deepcaverocksmall"), 0.01F);
        });
        GameEvents.triggerEvent(new GeneratedCaveMiniBiomesEvent(this, cg));
        PresetGeneration presets = new PresetGeneration(this);
        GameEvents.triggerEvent(new GenerateCaveStructuresEvent(this, cg, presets), (e) -> {
            cg.generateRandomCrates(0.03F, new int[]{ObjectRegistry.getObjectID("crate")});
        });
        GameEvents.triggerEvent(new GeneratedCaveStructuresEvent(this, cg, presets));
        IncursionBiome.generateEntrance(this, cg.random, 30, cg.rockTile, "deepstonebrickfloor", "deepstonefloor", "deepstonecolumn");
        GenerationTools.checkValid(this);
        if (incursionData instanceof BiomeExtractionIncursionData) {
            cg.generateGuaranteedOreVeins(100, 8, 16, ObjectRegistry.getObjectID("tungstenoredeeprock"));
        }

        cg.generateGuaranteedOreVeins(100, 6, 12, ObjectRegistry.getObjectID("upgradesharddeeprock"));
        cg.generateGuaranteedOreVeins(100, 6, 12, ObjectRegistry.getObjectID("alchemysharddeeprock"));
        GameEvents.triggerEvent(new GeneratedCaveOresEvent(this, cg));
    }*/
}
