package net.renzowit35.tutorialmodrw.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.renzowit35.tutorialmodrw.MCCourseMod;
import net.renzowit35.tutorialmodrw.block.custom.MagicBlock;
import net.renzowit35.tutorialmodrw.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MCCourseMod.MOD_ID);


    public static final DeferredBlock<Block> BLACK_OPAL_BLOCK = registerblock("black_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RAW_BLACK_OPAL_BLOCK = registerblock("raw_black_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLACK_OPAL_ORE = registerblock("black_opal_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLACK_OPAL_DEEPSLATE_ORE = registerblock("black_opal_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLACK_OPAL_NETHER_ORE = registerblock("black_opal_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLACK_OPAL_END_ORE = registerblock("black_opal_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerblock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));




    private static <T extends Block>DeferredBlock<T> registerblock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn );
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
