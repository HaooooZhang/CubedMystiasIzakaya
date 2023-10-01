package team.cztouhou.cmi.init;

import com.google.common.base.Supplier;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team.cztouhou.cmi.Main;

public class itemsinit {
    public static final Logger LOGGER = LoggerFactory.getLogger("cmi");

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Main.MODID);
    public static void registerall(IEventBus bus){
        ITEMS.register(bus);
    }



    public static final RegistryObject<Item> testitem = register("testitem",
            () -> new Item(new Item.Properties().tab(Main.MAIN_TAB)));





    static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        LOGGER.info("register item:"+name);
        return itemsinit.ITEMS.register(name, item);
    }
}
