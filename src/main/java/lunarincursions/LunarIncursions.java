package lunarincursions;

import lunarincursions.Incursion.Labyrinth.LabyrinthBiome;
import lunarincursions.Incursion.Labyrinth.LabyrinthIncursionBiome;
import lunarincursions.Incursion.Labyrinth.LabyrinthIncursionLevel;
import lunarincursions.Incursion.TestArena1.TestArena1Biome;
import lunarincursions.Incursion.TestArena1.TestArena1IncursionBiome;
import lunarincursions.Incursion.TestArena1.TestArena1IncursionLevel;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.BiomeRegistry;
import necesse.engine.registries.IncursionBiomeRegistry;
import necesse.engine.registries.LevelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ModEntry
public class LunarIncursions {
    private static final Logger log = LoggerFactory.getLogger(LunarIncursions.class);


    public void init(){
        System.out.println("🌙LunarIncursions init!");

        BiomeRegistry.registerBiome("labyrinthbiome", new LabyrinthBiome(), 0, null);
        IncursionBiomeRegistry.registerBiome(("labyrinthincursionbiome"), new LabyrinthIncursionBiome(), 2);
        LevelRegistry.registerLevel("labyrinthincursionlevel", LabyrinthIncursionLevel.class);

        TestArena1Biome result = BiomeRegistry.registerBiome("testarena1biome", new TestArena1Biome(), 0, null);
        IncursionBiomeRegistry.registerBiome("testarena1incursionbiome", new TestArena1IncursionBiome(), 2);
        LevelRegistry.registerLevel("testarena1incursionlevel", TestArena1IncursionLevel.class);
    }

    public void postInit(){
        System.out.println("🌙LunarIncursions postinit!");
    }
}
