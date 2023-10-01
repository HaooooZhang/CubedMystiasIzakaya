package team.cztouhou.cmi.client.tabs;


import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import team.cztouhou.cmi.init.itemsinit;

public class MainTab extends CreativeModeTab {
    public MainTab(String modId) {
        super("item_group_main");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(itemsinit.testitem.get());
    }
}


