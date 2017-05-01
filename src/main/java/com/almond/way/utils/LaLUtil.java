package com.almond.way.utils;

import java.util.ArrayList;
import java.util.List;

public class LaLUtil {
	
	public static double getDistance(LaL from, LaL to) {
		double R = 6378137;
		double latFrom = from.getLatitude() * Math.PI / 180.0;
		double latTo = to.getLatitude() * Math.PI / 180.0;
		double a = latFrom - latTo;
		double b = (from.getLongitude() - to.getLongitude()) * Math.PI /180.0;
		double sa2 = Math.sin(a / 2.0);
		double sb2 = Math.sin(b / 2.0);
		double d = 2 
				* R 
				* Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(latFrom) * Math.cos(latTo) * sb2 * sb2));
		return d;		
	}
	
	public static double getS(double a, double b, double c) {
		return (a + b + c) / 2;
	}
	
	public static double getH(double s, double a, double b, double c) {
		double h2 =  (4 * s * (s - a) * (s - b) * (s - c)) / (a * a);
		return Math.sqrt(h2);
	}
	
	public static List<LaL> getLalPoints() {
		List<Double> lon = new ArrayList<Double>();
		List<Double> lat = new ArrayList<Double>();

		lon.add(121.31256018996311);
		lat.add(31.279614976933726);
		
		lon.add(121.31269897077206);
		lat.add(31.279587315611572);
		
		lon.add(121.31284274290142);
		lat.add(31.27956764805616);
		
		lon.add(121.31301245834376);
		lat.add(31.279527890464557);
		
		lon.add(121.31320612759374);
		lat.add(31.279489058814164);
		
		lon.add(121.31342973994525);
		lat.add(31.27945714113793);
		
		lon.add(121.31360042922218);
		lat.add(31.279421476770523);
		
		lon.add(121.31377011667236);
		lat.add(31.27939384277573);
		
		lon.add(121.31393679569386);
		lat.add(31.279354250962932);
		
		lon.add(121.31407053919268);
		lat.add(31.279334792768104);
		
		lon.add(121.31425018429728);
		lat.add(31.279303206610408);
		
		lon.add(121.31442482900343);
		lat.add(31.27926866842667);
		
		lon.add(121.3145904851291);
		lat.add(31.27923718557258);
		
		lon.add(121.31476112163918);
		lat.add(31.279201717473555);
		
		lon.add(121.31489582952389);
		lat.add(31.279174368198127);
		
		lon.add(121.31503053469024);
		lat.add(31.279151035928226);
		
		lon.add(121.31517321784416);
		lat.add(31.2791277033031);
		
		lon.add(121.31545157709962);
		lat.add(31.27906911606701);
		
		lon.add(121.31561719008435);
		lat.add(31.279041801335055);
		
		lon.add(121.3158007477386);
		lat.add(31.27900248674148);
		
		lon.add(121.31598929104761);
		lat.add(31.27897519517403);
		
		lon.add(121.31612794317415);
		lat.add(31.278944006215006);
		
		lon.add(121.3162985104312);
		lat.add(31.278909798961536);
		
		lon.add(121.31646807408104);
		lat.add(31.278878620927888);
		
		lon.add(121.31664361490046);
		lat.add(31.278847466501986);
		
		lon.add(121.3168311122114); 
		lat.add(31.278808336951105);
		
		lon.add(121.31701062183372);
		lat.add(31.278770245873247);
		
		lon.add(121.3171671905135);
		lat.add(31.278743191040775);
		
		lon.add(121.31734170382367);
		lat.add(31.27871615786574);
		
		lon.add(121.31747133329203);
		lat.add(31.2786891545925);
		
		lon.add(121.31757503510654);
		lat.add(31.278670163331363);
		
		lon.add(121.31770964253745);
		lat.add(31.278643191199556);
		
		lon.add(121.31789309859889);
		lat.add(31.278604258698646);
		
		lon.add(121.31806259097598);
		lat.add(31.27857334944441);
		
		lon.add(121.31822908690533);
		lat.add(31.278546465425766);
		
		lon.add(121.31838560107968);
		lat.add(31.278511601924542);
		
		lon.add(121.31855507164575);
		lat.add(31.278480775290426);
		
		lon.add(121.31873051849183);
		lat.add(31.278453983372923);
		
		lon.add(121.31888701277005);
		lat.add(31.27842019712418);
		
		lon.add(121.31905247166752);
		lat.add(31.278385449130425);
		
		lon.add(121.31921394302987);
		lat.add(31.278362718222432);
		
//		lon.add(121.31256018996311);
//		lon.add(121.31269897077206);
//		lon.add(121.31284274290142);
//		lon.add(121.31301245834376);
//		lon.add(121.31320612759374);
//		lon.add(121.31342973994525);
//		lon.add(121.31360042922218);
//		lon.add(121.31377011667236);
//		lon.add(121.31393679569386);
//		lon.add(121.31407053919268);
//		
//		lat.add(31.279614976933726);
//		lat.add(31.279587315611572);
//		lat.add(31.27956764805616);
//		lat.add(31.279527890464557);
//		lat.add(31.279489058814164);
//		lat.add(31.27945714113793);
//		lat.add(31.279421476770523);
//		lat.add(31.27939384277573);
//		lat.add(31.279354250962932);
//		lat.add(31.279334792768104);
		
		List<LaL> lalPoints = new ArrayList<LaL>();
		for (int index = 0; index < lon.size(); index++) {
			LaL top = new LaL(lon.get(index), lat.get(index));
			lalPoints.add(top);
		}
		return lalPoints;
	}
}
