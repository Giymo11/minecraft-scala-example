package rip.hansolo.minecrafterooni

import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.{Item, ItemBlock}
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.registry.GameRegistry
import rip.hansolo.minecrafterooni.proxy.CommonProxy

/**
  * Created by Giymo11 on 22.07.2016.
  */
@Mod(modid = Reference.modid, version = Reference.version, modLanguage = "scala")
object Minecrafterooni {

  def ResourceLocation(id: String) = new ResourceLocation(Reference.modid, id)

  @SidedProxy(
    clientSide = "rip.hansolo.minecrafterooni.proxy.ClientProxy",
    serverSide = "rip.hansolo.minecrafterooni.proxy.ServerProxy",
    modId = Reference.modid
  )
  var proxy: CommonProxy = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    proxy.preInit(event)
  }

  @EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    proxy.init(event)
  }

  @EventHandler
  def postInit(event: FMLPostInitializationEvent): Unit = {
    proxy.postInit(event)
  }
}


