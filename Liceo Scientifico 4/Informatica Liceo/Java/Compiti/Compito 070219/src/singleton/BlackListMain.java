package singleton;

public class BlackListMain {

public static void main(String[] args) {
		
		//test in debug
		
		BlackListWebSite list = BlackListWebSite.getInstance();
		list.addWebSite("http://google.com");
		list.addWebSite("http://liceocuneo.it");
		boolean ris = list.isWebSiteBlocked("http://google.com");
		boolean ris1 = list.isWebSiteBlocked("http://test.it");
		
		System.out.println(ris);
		System.out.println(ris1);
		
		BlackListWebSite list1 = BlackListWebSite.getInstance();
		

	}


}
