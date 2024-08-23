package lunarincursions;

import lunarincursions.Incursion.Labyrinth.LabyrinthBiome;
import lunarincursions.Incursion.Labyrinth.LabyrinthIncursionBiome;
import lunarincursions.Incursion.Labyrinth.LabyrinthIncursionLevel;
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
    }

    public void postInit(){
        System.out.println("🌙LunarIncursions postinit!");
    }
}
