/**
 * Copyright (C) Lambda-Innovation, 2013-2014
 * This code is open-source. Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 */
package cn.otfurniture.proxy;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * @author WeAthFolD
 *
 */
public class OFClientProps {
	
	public static ResourceLocation 
		TEX_CABINET[] = {
			r("leon:textures/models/cabinet0.png"),
			r("leon:textures/models/cabinet1.png"),
			r("leon:textures/models/cabinet2.png"),
			r("leon:textures/models/cabinet3.png"),
			r("leon:textures/models/cabinet4.png")
		},
		TEX_SHELF = r("leon:textures/models/shelf.png"),
		TEX_SOFA[] = {
			r("leon:textures/models/sofa2.png"),
			r("leon:textures/models/sofa1.png"),
			r("leon:textures/models/sofa0.png")
		},
		TEX_BATHTUB[] = { 
			r("leon:textures/models/bathtub0.png"),
			r("leon:textures/models/bathtub1.png")
		},
		TEX_MIRROR[] = {
			r("leon:textures/models/mirror0.png"),
			r("leon:textures/models/mirror1.png"),
			r("leon:textures/models/mirror2.png"),
			r("leon:textures/models/mirror3.png"),
		},
		TEX_TV = r("leon:textures/models/tv.png"),
		TEX_TV_OPEN = r("leon:textures/models/tvo.png"),
		TEX_TV_ANIM[] = {
			r("leon:textures/models/tv0.png"),
			r("leon:textures/models/tv1.png"),
			r("leon:textures/models/tv2.png"),
			r("leon:textures/models/tv3.png"),
		},
		TEX_TVB = r("leon:textures/models/tvb.png"),
		TEX_TVB_OPEN = r("leon:textures/models/tvbo.png"),
		TEX_TVB_ANIM[] = {
			r("leon:textures/models/tvb0.png"),
			r("leon:textures/models/tvb1.png"),
			r("leon:textures/models/tvb2.png"),
			r("leon:textures/models/tvb3.png"),
		},
		TEX_SINK[] = {
			r("leon:textures/models/sink.png"),
			r("leon:textures/models/sinkb.png")
		},
		TEX_LAMP[] = {
			r("leon:textures/models/lamp.png"),
			r("leon:textures/models/lampo.png"),
			r("leon:textures/models/lampb.png"),
			r("leon:textures/models/lampob.png")
		},
		TEX_FSHELF = r("leon:textures/models/fshelf.png"),
		TEX_LAMPL[] = {
			r("leon:textures/models/lampl.png"),
			r("leon:textures/models/lamplo.png"),
			r("leon:textures/models/lamplb.png"),
			r("leon:textures/models/lamplob.png")
		},
		TEX_CHAIR[] = {
			r("leon:textures/models/chair.png"),
		 	r("leon:textures/models/chairb.png"),
		 	r("leon:textures/models/chairy.png"),
		 	r("leon:textures/models/chairyb.png")
		},
		TEX_DESK[] = {
			r("leon:textures/models/desk.png"),
			r("leon:textures/models/deskb.png"),
			r("leon:textures/models/deskf.png"),
			r("leon:textures/models/desky.png"),
			r("leon:textures/models/deskyb.png")
		},
		TEX_KSHELF[] = {
			r("leon:textures/models/kshelf0.png"),
			r("leon:textures/models/kshelf1.png"),
			r("leon:textures/models/kshelf2.png"),
			r("leon:textures/models/kshelf3.png"),
		},
		TEX_KSINK[] = {
			r("leon:textures/models/ksink0.png"),
			r("leon:textures/models/ksink1.png")
		},
		TEX_KSSHELF[] = {
			r("leon:textures/models/ksshelf0.png"),
			r("leon:textures/models/ksshelf1.png"),
			r("leon:textures/models/ksshelf2.png")
		},
		TEX_CLOCK[] = {
			r("leon:textures/models/clock0.png"),
			r("leon:textures/models/clock1.png")
		},
		TEX_WDESK[] = {
			r("leon:textures/models/wdesk0.png"),
			r("leon:textures/models/wdesk1.png")
		},
		TEX_TSHELF[] = {
			r("leon:textures/models/tshelf0.png"),
			r("leon:textures/models/tshelf1.png"),
			r("leon:textures/models/tshelf2.png"),
			r("leon:textures/models/tshelf3.png"),
		},
		TEX_SCHAIR[] = {
			r("leon:textures/models/schair0.png"),
			r("leon:textures/models/schair1.png"),
			r("leon:textures/models/schair2.png"),
		},
		TEX_BED[] = {
			r("leon:textures/models/bed0.png"),
			r("leon:textures/models/bed1.png")
		},
		TEX_TVSHELF = r("leon:textures/models/tvshelf.png"),
		TEX_OILLAMP[] = {
			r("leon:textures/models/oillamp0.png"),
			r("leon:textures/models/oillamp1.png")
		},
		TEX_HANGER = r("leon:textures/models/hanger.png"),
		TEX_PIANO = r("leon:textures/models/piano.png"),
		TEX_GUI_LEN = r("leon:textures/gui/scope.png"),
		TEX_GUI_DIALOGUE = r("leon:textures/gui/dialogue.png"),
		TEX_CANDLE_HOLDER = r("leon:textures/models/cholder.png"),
		TEX_WINE = r("leon:textures/models/wine.png"),
		TEX_BCURTAIN[] = {
			r("leon:textures/models/bcurtain00.png"),
			r("leon:textures/models/bcurtain01.png"),
			r("leon:textures/models/bcurtain10.png"),
			r("leon:textures/models/bcurtain11.png"),
		},
		TEX_SCURTAIN[] = {
			r("leon:textures/models/scurtain00.png"),
			r("leon:textures/models/scurtain01.png"),
			r("leon:textures/models/scurtain10.png"),
			r("leon:textures/models/scurtain11.png"),
		},
		TEX_MCURTAIN[] = {
			r("leon:textures/models/mcurtain00.png"),
			r("leon:textures/models/mcurtain01.png"),
			r("leon:textures/models/mcurtain10.png"),
			r("leon:textures/models/mcurtain11.png"),
		},
		TEX_LCURTAIN[] = {
			r("leon:textures/models/lcurtain00.png"),
			r("leon:textures/models/lcurtain01.png")
		},
		TEX_CHANDELIER = r("leon:textures/models/chandelier.png");
		
	public static IModelCustom
		MDL_CABINET = AdvancedModelLoader.loadModel(r("leon:models/cabinet.obj")),
		MDL_SHELF[] = {
			AdvancedModelLoader.loadModel(r("leon:models/shelf0.obj")),
			AdvancedModelLoader.loadModel(r("leon:models/shelf1.obj")),
			AdvancedModelLoader.loadModel(r("leon:models/shelf2.obj"))
		},
		MDL_SOFA[] = {
			AdvancedModelLoader.loadModel(r("leon:models/sofa_small.obj")),
			AdvancedModelLoader.loadModel(r("leon:models/sofa_medium.obj")),
			AdvancedModelLoader.loadModel(r("leon:models/sofa_large.obj")),
		},
		MDL_BATHTUB = AdvancedModelLoader.loadModel(r("leon:models/bathtub.obj")),
		MDL_SINK = AdvancedModelLoader.loadModel(r("leon:models/sink.obj")),
		MDL_MIRROR = AdvancedModelLoader.loadModel(r("leon:models/mirror.obj")),
		MDL_TV = AdvancedModelLoader.loadModel(r("leon:models/tv.obj")),
		MDL_LAMP = AdvancedModelLoader.loadModel(r("leon:models/lamp.obj")),
		MDL_LAMPL = AdvancedModelLoader.loadModel(r("leon:models/lampl.obj")),
		MDL_DESK = AdvancedModelLoader.loadModel(r("leon:models/desk.obj")),
		MDL_CHAIR = AdvancedModelLoader.loadModel(r("leon:models/chair.obj")),
		MDL_FILE_SHELF = AdvancedModelLoader.loadModel(r("leon:models/fshelf.obj")),
		MDL_KSHELF = AdvancedModelLoader.loadModel(r("leon:models/kshelf.obj")),
		MDL_KSINK = AdvancedModelLoader.loadModel(r("leon:models/ksink.obj")),
		MDL_KSSHELF = AdvancedModelLoader.loadModel(r("leon:models/ksshelf.obj")),
		MDL_CLOCK = AdvancedModelLoader.loadModel(r("leon:models/clock.obj")),
		MDL_WDESK = AdvancedModelLoader.loadModel(r("leon:models/wdesk.obj")),
		MDL_TSHELF = AdvancedModelLoader.loadModel(r("leon:models/tshelf.obj")),
		MDL_SCHAIR = AdvancedModelLoader.loadModel(r("leon:models/schair.obj")),
		MDL_BED = AdvancedModelLoader.loadModel(r("leon:models/bed.obj")),
		MDL_TVSHELF = AdvancedModelLoader.loadModel(r("leon:models/tvshelf.obj")),
		MDL_OILLAMP = AdvancedModelLoader.loadModel(r("leon:models/oillamp.obj")),
		MDL_HANGER = AdvancedModelLoader.loadModel(r("leon:models/hanger.obj")),
		MDL_PIANO = AdvancedModelLoader.loadModel(r("leon:models/piano.obj"));
	
	private static ResourceLocation r(String s) {
		return new ResourceLocation(s);
	}
}
