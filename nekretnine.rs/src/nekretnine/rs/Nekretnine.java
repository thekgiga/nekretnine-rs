package nekretnine.rs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Nekretnine {

	public static final String USER_AGENT = "Mozilla/5.0";

	public static void getData(){
		Document doc;
		try {
			doc = Jsoup.parse(sendGet("https://www.nekretnine.rs/stambeni-objekti/stanovi/izdavanje-prodaja/izdavanje/zemlja/srbija/grad/beograd/deo-grada/bezanija-blok-49_bezanija-blok-60_blok-11a-opstina-nbg_blok-11b_blok-11c-stari-merkator_blok-12-yubc_blok-13-palata-federacije_blok-14-park-usce_blok-15-park-usce_blok-16-usce-soping-centar_blok-17-staro-sajmiste_blok-19-sava-centar_blok-19a_blok-20-hotel-hayat_blok-21-10-gimnazija_blok-22_blok-23_blok-24-super-vero_blok-25-arena_blok-26_blok-28-potkovica_blok-29_blok-3_blok-30-b92_blok-31-merkator_blok-32-crkva-sv-dimitrija_blok-33-genex-kula_blok-34-studentski-grad_blok-35-sc-11-april_blok-37_blok-38-os-ratko-mitrovic_blok-39_blok-4-politehnicka-akademija_blok-40_blok-41-expo-centar_blok-41a-gtc_blok-42_blok-43-buvlja-pijaca_blok-44-piramida_blok-45-tc-enjub_blok-5_blok-58_blok-60-airport-city_blok-61_blok-62_blok-63_blok-64_blok-66-tranvajska-stala_blok-66a_blok-67a_blok-68_blok-7-paviljoni_blok-70-kineski-tc_blok-71_blok-72_blok-7a-paviljoni_blok-8-paviljoni_blok-8a-paviljoni_blok-9_blok-9a-dom-zdravlja_blok-1-fontana_hotel-jugoslavija-blok-11_blok-8a_blok-67_kvantas-blok-53_blok-65_blok-10_blok-70a/cena/0_300/sobe/2_5/poslednja/2/poredjaj-po/datumu_nanize/lista/po_stranici/50/"));
			//			System.out.println(doc);
			Elements searchResults = doc.getElementsByClass("resultList fixed");
			for (Element element : searchResults) {
				System.out.println(element.child(0).attr("href"));

			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static String sendGet(String urlUrl) throws Exception {

		String url = urlUrl;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		//		System.out.println("\nSending 'GET' request to URL : " + url);
		//		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		return response.toString();

	}
}
