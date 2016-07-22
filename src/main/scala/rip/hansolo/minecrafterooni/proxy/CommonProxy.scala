package rip.hansolo.minecrafterooni.proxy

import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.item.ItemBlock
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.registry.GameRegistry
import rip.hansolo.minecrafterooni.Minecrafterooni
import rip.hansolo.minecrafterooni.blocks.{SidedTexture, SimpleTexture}

/**
  * Created by Giymo11 on 22.07.2016.
  */
abstract class CommonProxy {

  def preInit(event: FMLPreInitializationEvent): Unit = {

    def registerBlock(block: Block): Unit = {
      val item = new ItemBlock(block)

      item.setRegistryName(block.getRegistryName)
      item.setUnlocalizedName(block.getUnlocalizedName)

      GameRegistry.register(block)
      GameRegistry.register(item)

      addToRender(item)
    }

    registerBlock(new SimpleTexture)
    registerBlock(new SidedTexture)
  }

  def addToRender(item: ItemBlock): Unit

  def init(event: FMLInitializationEvent): Unit = {
    println(s"*Scala* DIRT BLOCK >> ${Blocks.DIRT.getUnlocalizedName}")
  }
  def postInit(event: FMLPostInitializationEvent): Unit = {

  }
}
