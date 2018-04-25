package Functionality;

import java.awt.Color;

public enum Colour {
	
	//thanks to wikipedia for a colour list
	
	white (Color.WHITE, "white"),
	
	red (Color.RED, "red"),
	
	
	orange (Color.ORANGE, "orange"),
	yellow (Color.YELLOW, "yellow"),
	purple (Color.MAGENTA, "purple"),
	pink(Color.PINK, "pink"),
	
	brown(new Color(165,82,45), "brown"),
	aqua(new Color(0,255,255), "aqua"),
	beige(new Color(245,245,220), "beige"),
	black (Color.BLACK, "black"),
	blue (Color.blue, "blue"),
	bronze(new Color(205,127,50), "bronze"),
	bubble_gum(new Color(255,193,204), "bubble gum"),
	citrine(new Color(228,208,10), "citrine"),
	corn(new Color(251,236,93), "corn"),
	diamond(new Color(185,242,255), "diamond"),
	dirt(new Color(155,118,83), "dirt"),
	duke_blue(new Color(0,0,156), "duke blue"),
	egg_shell(new Color(240,234,214),"egg shell"),
	emerald(new Color(80,200,120), "emerald"),
	eminence(new Color(108,48,130), "eminence"),
	eucalyptus(new Color(68,215,168), "eucalyptus"),
	facebook_blue(new Color(57,86,156), "facebook blue"),
	fandango(new Color(181,51,137), "fandango"),
	folly(new Color(255,0,79),"folly"),
	fulvous(new Color(228,132,0), "fulvous"),
	fuzzy_wuzzy(new Color(204,102,102), "fuzzy wuzzy"),
	//end of A - F
	gold(new Color(165,124,0),"gold"),
	grape(new Color(111,45,168), "grape"),
	green (Color.GREEN, "green"),
	heliotrope(new Color(223,115,225), "heliotrope"),
	imperial_purple(new Color(96,47,107), "imperial purple"),
	
	seafoam_green(new Color(114,214,155),"seafoam green");//this is only here because Adam asked for it
	
	
	
	
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
