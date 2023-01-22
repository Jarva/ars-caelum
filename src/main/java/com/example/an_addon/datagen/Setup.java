package com.example.an_addon.datagen;

import com.example.an_addon.ExampleANAddon;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleANAddon.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Setup {

    //use runData configuration to generate stuff, event.includeServer() for data, event.includeClient() for assets
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        gen.addProvider(event.includeServer(), new ArsProviders.ImbuementProvider(gen));
        gen.addProvider(event.includeServer(), new ArsProviders.GlyphProvider(gen));
        gen.addProvider(event.includeServer(), new ArsProviders.EnchantingAppProvider(gen));
        gen.addProvider(event.includeServer(), new ArsProviders.CrushProvider(gen));
        gen.addProvider(event.includeServer(), new ArsProviders.PatchouliProvider(gen));
        gen.addProvider(event.includeClient(), new LangGen(gen, ExampleANAddon.MODID, "en_us"));
        gen.addProvider(event.includeServer(), new RecipeData(gen));
    }

}
