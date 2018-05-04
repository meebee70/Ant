package Functionality;

import java.awt.Color;
import java.util.Random;

public enum Colour {
	
	//thanks to wikipedia for a colour list
	
	
	
	
	
	
	
	
	
	aqua(new Color(0,255,255), "aqua"),
//	end of A
	brown(new Color(165,82,45), "brown"),
	beige(new Color(245,245,220), "beige"),
	black (Color.BLACK, "black"),
	blue (Color.blue, "blue"),
	bronze(new Color(205,127,50), "bronze"),
	bubble_gum(new Color(255,193,204), "bubble gum"),
//	end of B
	citrine(new Color(228,208,10), "citrine"),
	corn(new Color(251,236,93), "corn"),
//	end of C
	diamond(new Color(185,242,255), "diamond"),
	dirt(new Color(155,118,83), "dirt"),
	duke_blue(new Color(0,0,156), "duke blue"),
//	end of D
	egg_shell(new Color(240,234,214),"egg shell"),
	emerald(new Color(80,200,120), "emerald"),
	eminence(new Color(108,48,130), "eminence"),
	eucalyptus(new Color(68,215,168), "eucalyptus"),
//	end of E
	facebook_blue(new Color(57,86,156), "facebook blue"),
	fandango(new Color(181,51,137), "fandango"),
	folly(new Color(255,0,79),"folly"),
	fulvous(new Color(228,132,0), "fulvous"),
	fuzzy_wuzzy(new Color(204,102,102), "fuzzy wuzzy"),
//	end of F
	gold(new Color(165,124,0),"gold"),
	grape(new Color(111,45,168), "grape"),
	green (Color.GREEN, "green"),
//	end of G
	heliotrope(new Color(223,115,225), "heliotrope"),
//	end of H
	imperial_purple(new Color(96,47,107), "imperial purple"),
	indigo(new Color(75,0,130), "indigo"),
	ivory(new Color(255,255,240), "ivory"),
//	end of I
	jade(new Color(0,168,107), "jade"),
	jasper(new Color(215,59,62), "jasper"),
	jet(new Color(52,52,52), "jet"),
//	end of J
	kiwi(new Color(142,229,63), "kiwi"),
//	end of K
	lava(new Color(207,16,32), "lava"),
	lemon(new Color(255,247,0), "lemon"),
	licorice(new Color(26,17,16),"licorice"),
//	end of L
	mahogany(new Color(192,64,0), "mahogany"),
	mango(new Color(253,190,2), "mango"),
	mud(new Color(111,83,61), "mud"),
	mystic_red(new Color(255,34,0), "mystic red"),
//	end of M
	neon_green(new Color(57,255,20), "neon green"),
//	end of N
	ochre(new Color(204,119,34),"ochre"),
	olive(new Color(128,128,0), "olive"),
	onyx(new Color(53,56,57), "onyx"),
	orange (Color.ORANGE, "orange"),
	orchid(new Color(218,112,214),"orchid"),
//	end of O
	pear(new Color(209,226,49), "pear"),
	phlox(new Color(223,0,255), "phlox"),
	pink(Color.PINK, "pink"),
	purple (Color.MAGENTA, "purple"),
	puce(new Color(204,136,153), "puce"),
	pumpkin(new Color(255,117,24),"pumpkin"),
//	end of P
	quartz(new Color(81,72,79),"quartz"),
//	end of Q
	red (Color.RED, "red"),
	rose(new Color(255,0,128), "rose"),
//	end of R
	salmon(new Color(250,128,114),"salmon"),
	sapphire(new Color(15,82,186),"sapphire"),
	school_bus_yellow(new Color(255,216,0),"school bus yellow"),
	seafoam_green(new Color(114,214,155),"seafoam green"),//this is only here because Adam asked for it
	silver(new Color(192,192,192),"silver"),
//	end of S
	tan(new Color(210,180,140), "tan"),
	teal(new Color(0,128,128), "teal"),
	tomato(new Color(255,99,71),"tomato"),
	tulip(new Color(255,135,141),"tulip"),
//	end of T
	umm(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)),"umm"),//this colour changes colour every time the program is launched
//	end of U
	vanilla(new Color(243,229,171),"vanilla"),
	viridian(new Color(64,130,109),"viridian"),
//	end of V
	white (Color.WHITE, "white"),
//	end of W
	xbox_green(new Color(14,122,13),"Xbox green"),
//	end of X
	yellow (Color.YELLOW, "yellow"),
//	end of Y
	zaffre(new Color(0,20,168), "zaffre"),
	zomp(new Color(57,167,142),"zomp");
//	end of Z
//	end of List
	
	private Color colour;
	private String colourName;
	private Colour (Color c, String s){
		colour = c;
		colourName = s;
	}
	
	public String toString(){
		return colourName;
	}
	
	public static Colour toColour(String s){
		s = s.toLowerCase();
		
		for (Colour c : Colour.values()){
			if (s.equals(c.colourName)){
				return c;
			}
		}
		
		return null;
	}
	
	public Color getColor(){
		return colour;
	}
	
	public static String getAllColours(){
		String toReturn = "";
		for (Colour c : Colour.values()){
			toReturn += c.colourName + ", ";
		}
		
		toReturn = toReturn.substring(0, toReturn.length() - 2);
		
		return toReturn;
	}
	

}
