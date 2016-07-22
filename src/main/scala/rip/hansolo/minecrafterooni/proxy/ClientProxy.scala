package rip.hansolo.minecrafterooni.proxy

import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.{Item, ItemBlock}
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import rip.hansolo.minecrafterooni.{Minecrafterooni, Reference}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by Giymo11 on 22.07.2016.
  */
class ClientProxy extends CommonProxy {

  val blockItems: mutable.ListBuffer[ItemBlock] = ListBuffer()

  lazy val creativeTab = new CreativeTabs(Reference.modid) {
    override def getTabIconItem: Item = Item.REGISTRY.getObject(Minecrafterooni.ResourceLocation(Reference.BlockIds.sidedTexture))
  }

  override def addToRender(item: ItemBlock): Unit = {
    blockItems.append(item)
  }

  override def preInit(event: FMLPreInitializationEvent): Unit = {
    super.preInit(event)

    for(item <- blockItems) {
      renderBlockItem(item)
      item.block.setCreativeTab(creativeTab)
    }
  }

  def renderBlockItem(item: Item, metadata: Int = 0): Unit = {
    val model = new ModelResourceLocation(item.getRegistryName, "inventory")
    ModelLoader.setCustomModelResourceLocation(item, metadata, model)
  }
}
