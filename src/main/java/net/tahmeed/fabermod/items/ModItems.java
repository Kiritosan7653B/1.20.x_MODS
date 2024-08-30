package net.tahmeed.fabermod.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tahmeed.fabermod.FaberMod;
import net.tahmeed.fabermod.items.custom.FuelItem;
import net.tahmeed.fabermod.items.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FaberMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AMEDYRE = ITEMS.register("amedyre",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AMEDYRE = ITEMS.register("raw_amedyre",
            ()-> new Item(new Item.Properties()));


    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            ()-> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            ()-> new FuelItem( new Item.Properties(), 400));
    public static final RegistryObject<Item> OIL_DRUM = ITEMS.register("oil_drum",
            ()-> new FuelItem( new Item.Properties(), 2000));


    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(20)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
