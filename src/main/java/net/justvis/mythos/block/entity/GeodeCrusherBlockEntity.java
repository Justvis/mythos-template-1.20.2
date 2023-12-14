package net.justvis.mythos.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.justvis.mythos.item.ModItems;
import net.justvis.mythos.recipe.GeodeCrusherRecipe;
import net.justvis.mythos.screen.GeodeCrusherScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GeodeCrusherBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int OUTPUT_SLOT2 = 2;
    private static final int OUTPUT_SLOT3 = 3;
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 200;


    public GeodeCrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GEODE_CRUSHER_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GeodeCrusherBlockEntity.this.progress;
                    case 1 -> GeodeCrusherBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> GeodeCrusherBlockEntity.this.progress = value;
                    case 1 -> GeodeCrusherBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Geode Crusher");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("geode_crusher.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("geode_crusher.progress");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GeodeCrusherScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        if(isOutputSlotEmptyOrReceivable()) {
            if(this.hasRecipe()) {
                this.increaseCraftProgress();
                markDirty(world, pos, state);

                if(hasCraftingFinished()) {
                    this.craftItem();
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<RecipeEntry<GeodeCrusherRecipe>> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);

        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));

        double test = Math.random() * 20;
        if (test < 5)
            this.setStack(OUTPUT_SLOT3, new ItemStack(ModItems.CALCIFIED_BLOOD, getStack(OUTPUT_SLOT3).getCount() + 1));
        if (test < 10)
            this.setStack(OUTPUT_SLOT2, new ItemStack(ModItems.ARCANIST_POWDER, getStack(OUTPUT_SLOT2).getCount() + 1));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        return checkOutput();
    }

    private boolean checkOutput() {
        Optional<RecipeEntry<GeodeCrusherRecipe>> recipe = getCurrentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot1(recipe.get().value().getResult(null))
                && canInsertItemIntoOutputSlot1(recipe.get().value().getResult(null).getItem());
    }

    private Optional<RecipeEntry<GeodeCrusherRecipe>> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for(int i = 0; i < this.size(); i++) {
            inv.setStack(i, this.getStack(i));
        }

        return getWorld().getRecipeManager().getFirstMatch(GeodeCrusherRecipe.Type.INSTANCE, inv, getWorld());
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount()
                || this.getStack(OUTPUT_SLOT2).isEmpty() || this.getStack(OUTPUT_SLOT2).getCount() < this.getStack(OUTPUT_SLOT2).getMaxCount()
                || this.getStack(OUTPUT_SLOT3).isEmpty() || this.getStack(OUTPUT_SLOT3).getCount() < this.getStack(OUTPUT_SLOT3).getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot1(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot1(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot2(Item item) {
        return this.getStack(OUTPUT_SLOT2).getItem() == item || this.getStack(OUTPUT_SLOT2).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot2(ItemStack result) {
        return this.getStack(OUTPUT_SLOT2).getCount() + result.getCount() <= getStack(OUTPUT_SLOT2).getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot3(Item item) {
        return this.getStack(OUTPUT_SLOT3).getItem() == item || this.getStack(OUTPUT_SLOT3).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot3(ItemStack result) {
        return this.getStack(OUTPUT_SLOT3).getCount() + result.getCount() <= getStack(OUTPUT_SLOT3).getMaxCount();
    }
}
