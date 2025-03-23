package net.renzowit35.tutorialmodrw.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.renzowit35.tutorialmodrw.MCCourseMod;
import net.renzowit35.tutorialmodrw.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);


    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TAB.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tutorialmodrw.black_opal_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLACK_OPAL);
                        output.accept(ModItems.RAW_BLACK_OPAL);
                        output.accept(ModItems.CHAINSAW);
                        output.accept(ModItems.TOMATO);
                        output.accept(ModItems.FROSTFIRE_ICE);
                    }))
                    .build());

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TAB.register("black_opal_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.tutorialmodrw.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"black_opal_items_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BLACK_OPAL_BLOCK);
                        output.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);
                        output.accept(ModBlocks.BLACK_OPAL_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_NETHER_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_END_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                    }))
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
