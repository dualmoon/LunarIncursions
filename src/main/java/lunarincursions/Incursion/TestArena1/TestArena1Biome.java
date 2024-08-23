package lunarincursions.Incursion.TestArena1;

import necesse.engine.AbstractMusicList;
import necesse.engine.MusicList;
import necesse.engine.registries.MusicRegistry;
import necesse.engine.sound.GameMusic;
import necesse.entity.mobs.PlayerMob;
import necesse.level.maps.Level;
import necesse.level.maps.biomes.Biome;
import necesse.level.maps.biomes.MobSpawnTable;

public class TestArena1Biome extends Biome {
    public static MobSpawnTable critters;
    public static MobSpawnTable mobs;

    public TestArena1Biome() {
    }

    public MobSpawnTable getCritterSpawnTable(Level level) {
        return critters;
    }

    public MobSpawnTable getMobSpawnTable(Level level) {
        return mobs;
    }

    public AbstractMusicList getLevelMusic(Level level, PlayerMob perspective) {
        return new MusicList(new GameMusic[]{MusicRegistry.SecretsOfTheForest});
    }

    static {
        critters = (new MobSpawnTable()).include(Biome.defaultCaveCritters);
        mobs = (new MobSpawnTable()).add(100, "skeleton").add(40, "skeletonthrower").add(45, "deepcavespirit");
    }
}
