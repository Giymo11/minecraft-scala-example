package rip.hansolo.minecrafterooni

import net.minecraft.block.Block
import net.minecraft.block.material.Material

/**
  * Created by Giymo11 on 22.07.2016.
  */
class BaseBlock(id: String, material: Material) extends Block(material){
  setRegistryName(Minecrafterooni.ResourceLocation(id))
  setUnlocalizedName(id)
}
