package net.renzowit35.tutorialmodrw.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.renzowit35.tutorialmodrw.MCCourseMod;
import net.renzowit35.tutorialmodrw.item.ModItems;
import net.renzowit35.tutorialmodrw.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider>
            lookupProvider, CompletableFuture<TagLookup<Block>> blockTags,
                              @Nullable ExistingFileHelper existingFileHelper) {super(output, lookupProvider, blockTags, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Items.TRANSFORMABLE_ITEM)
                .add(ModItems.BLACK_OPAL.get())
                .add(ModItems.RAW_BLACK_OPAL.get())
                .add(Items.DIAMOND)
                .add(Items.OBSIDIAN);


    }
}
