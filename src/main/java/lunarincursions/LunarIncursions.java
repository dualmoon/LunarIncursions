package lunarincursions;

import lunarincursions.Incursion.Labyrinth.LabyrinthBiome;
import lunarincursions.Incursion.Labyrinth.LabyrinthIncursionBiome;
import lunarincursions.Incursion.Labyrinth.LabyrinthIncursionLevel;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.*;
import necesse.engine.util.GameRandom;
import necesse.inventory.item.miscItem.GatewayTabletItem;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necesse.level.maps.incursion.IncursionBiome;

@ModEntry
public class LunarIncursions {
    public void init(){
        System.out.println("🌙LunarIncursions init!");

        BiomeRegistry.registerBiome("labyrinthbiome", new LabyrinthBiome(), 0, null);
        IncursionBiomeRegistry.registerBiome("labyrinthincursionbiome", new LabyrinthIncursionBiome(), 2);
        LevelRegistry.registerLevel("labyrinthincursionlevel", LabyrinthIncursionLevel.class);
    }

    public void postInit(){
        // Example item recipe, crafted in inventory for 2 iron bars
        Recipes.registerModRecipe(new Recipe(
            "gatewaytablet",
            1,
            RecipeTechRegistry.NONE,
            new Ingredient[]{
                new Ingredient("ironbar", 2)
            }
        ).onCrafted((event) -> {
            event.resultItem.getGndData().setItem("recipeBiome", null);
            IncursionBiome biome = IncursionBiomeRegistry.getBiome("labyrinthincursionbiome");
            GatewayTabletItem.initializeCustomGateTablet(event.resultItem, GameRandom.globalRandom, 1, biome);
        }).showAfter("woodboat"));
        System.out.println("🌙LunarIncursions postinit!");
    }
}
