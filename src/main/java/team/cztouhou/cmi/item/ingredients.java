package team.cztouhou.cmi.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.cztouhou.cmi.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


public class ingredients extends Item implements allaffects {

    public ArrayList itemaffect;
    public ingredients(Properties settings) {
        super(settings);
    }
    @Override
    public @NotNull ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        ArrayList itemaffect = new ArrayList();
        itemaffect.add(false);
        itemaffect.add(true);
        for (int i = 0; i < allaffects.getlist().size(); i++) {
            String affect = (String) allaffects.getlist().get(i);
            Boolean item = (Boolean) itemaffect.get(i);
            stack.getOrCreateTagElement("affects").putBoolean(affect, item);
        }
        return stack;
    }

    //@Override
    /*
    public ItemStack getInstance(ArrayList itemaffect){
        ItemStack stack = super.getDefaultInstance();
        for (int i = 0; i < allaffects.getlist().size(); i++) {
            String affect = (String) allaffects.getlist().get(i);
            Boolean item = (Boolean) itemaffect.get(i);
            stack.getOrCreateTagElement("affects").putBoolean(affect, item);
        }
        return stack;
    }
     */
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag context) {
        CompoundTag nbt = stack.getTagElement("affects");
        if (nbt != null){
            if (nbt.getBoolean("spicy")){
                tooltip.add(Component.translatable("tooltips."+ Main.MODID+".spicy").copy()
                        .withStyle(ChatFormatting.RED));
            }
            if (nbt.getBoolean("sour")) {
                tooltip.add(Component.translatable("tooltips." + Main.MODID + ".sour").copy()
                        .withStyle(ChatFormatting.YELLOW));
            }
        }
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().isClientSide()) return InteractionResult.PASS;
        AtomicReference<InteractionResult> result = new AtomicReference<>(InteractionResult.PASS);
        return result.get();
    }



    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> stacks) {
        if(this.allowedIn(group)) {
            stacks.add(getDefaultInstance());
        }
    }
}