/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import junit.framework.TestCase;

/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision$
 */
public class UrlValidatorTest extends TestCase {

   private final boolean printStatus = false;
   private final boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   @Override
protected void setUp() {
      for (int index = 0; index < testPartsIndex.length - 1; index++) {
         testPartsIndex[index] = 0;
      }
   }

   public void testIsValid() {
        testIsValid(testUrlParts, UrlValidator.ALLOW_ALL_SCHEMES);
        setUp();
        long options =
            UrlValidator.ALLOW_2_SLASHES
                + UrlValidator.ALLOW_ALL_SCHEMES
                + UrlValidator.NO_FRAGMENTS;

        testIsValid(testUrlPartsOptions, options);
   }
   
     
   //***
   // BEGIN GROUP 34 RANDOM TESTS
   //***
   
   /***********************************************************************************************************
    * GENERATED URL SUB-STRINGS
    * These strings are used to automatically generate URLs and they are created by a combination of manual, 
    * automatic, and searched URL partition strings.
    * **********************************************************************************************************/    

      String[] valid_scheme_partition = {
   		   "https://", 
   		   "ftp://", 
   		   "h3t://", 
   		   "android://", 
   		   "aaaaa://", 
   		   "zttpp://", 
   		   "cap://",
   		   "grep://",
   		   "about://", 
   		   "dns://",
   		   "dvb://", 
   		   "geo://",
   		   "svn://", 
   		   "tip://",
   		   "unreal://", 
   		   "urn://",
   		   "xfire://", 
   		   "soap.beeps://",
   		   "simpleledger://", 
   		   "eid://", 
   		   "mac://",
};
      

      
      String[] invalid_scheme_partition = {
   		   "://",
   		   "3ht://", 
   		   "http/", 
   		   " ", 
   		   "ht..tp/", 
              "h htp ",
              "..h..", 
              "33hh ",
              "$//", 
              "// //",
              "* *//", 
              "44ht://",
              "  //  x ", 
              "/??..",
              "Httttp :", 
              "3xt://",
              "sttp: ", 
              "google;",
              ":google ", 
              "goo:gle ",
              "goo gle ", 
};
      String[] valid_authority_partition = {
   			"www.google.com", 
   			"www.google.co.in", 
   			"255.255.255.255", 
   			"1.1.1.1", 
   	        "1.2.3.4",
   	        "www.cisco.com", 
   	        "www.abcdefghijklmn.com",
   	        "cisco.com", 
   	        "tesla.com",
   	        "www.tesla.com", 
   	        "r2d3e4.com",
   	        "spacex.com", 
   	        "www.1234.com",
   	        "www.cisco.us", 
   	        "www.cisco.io",
   	        "www.cisco.eu", 
   	        "www.cisco.au",
   	        "www.cisco.cn", 
   	        "www.cisco.de",
   	        "www.cisco.edu", 
   	        "www.cisco.gov",
   	        
   	};



   	String[] invalid_authority_partition = {
   			"www.google.ckosa",
   			"zzz", 
   			"1.2.3.4.5", 
   			"256.256.256.256", 
   	        "1.2.3.4.",
   	        "1.2.3", 
   	        ".1.2.3.4",
   	        "go.a", 
   	        "go.a1a",
   	        "go.1aa", 
   	        "aaa.",
   	        ".aaa", 
   	        "aaa",
   	        " www.sony.cormp", 
   	        " www.nintendo.sdra",
   	        "aven.ger.s",
   	        "mtl.g&r.s0lid", 
   	        "!a.mb@.man",
   	        " fdsa.fda.da.ada", 
   	        "23432.23.34.3.2 ", 
   	        "wut.up.d@wg", 
   	       

   			};
   	   
   	String[] valid_path_partition = {
   			   "/maps", 
   			   "/123458", 
   			   "/maps/", 
   			   "", 
   			   "/x1234", 
   	           "/1234",
   	           "/path1/path2", 
   	           "/123/456/789",
   	           "/search", 
   	           "/a",
   	           "/axfleidl", 
   	           "/dkendkdkvkle",
   	           "/a/b/c/d/e/f/g", 
   	           "/1/a/2/b/3/c/4/d",
   	           "/#/file",
   	           "/z555/444", 
   	           "/aaaaaa",
   	           "/$1$3", 
   	           "/abcd$x/",
   	           "/.", 
   	           "/a/$",
   	        
   	          
   	};


   	String[] invalid_path_partition = {
   			"//maps",
   			"/maps//file", 
   			"/..",
   			"/3j3onSon�.o33 ", 
   	        "  / #/ ^f.il  eio",
   	        " /../com@mebro", 
   	        "/////secsay...cani",
   	        "   /hit/me/baby/one/more/ ^  time", 
   	        "how_.can_.she_.slap",
   	        "././   ./././.0/.0", 
   	        "/.^.^.:)/ ",
   	        "/6si66�../",
   	        "/fda32...3234//432", 
   	        "//fdsar...32/52r/dd",
   	        "/fd32/43..3//3.", 
   	        " /...s ingaloudsongkd-.-.", 
   	        "/-   .0.0...,0    ",
   	        "/._._._._--.-/  ", 
   	        "/fds,3,2.302.32////..df3.32./.3.23..",
   	        "//r22/342/s223//34/ ", 
   	        "/fds//32f/d-///d/s/d/43/", 
   	       
   	};
   	String[] valid_port_partition = {
   			   ":80", 
   			   ":65535", 
   			   ":0", 
   			   "",
   			   ":812", 
   	           ":3000",
   	           ":3123 ", 
   	           ":543",
   	           ":421 ", 
   	           ":34123",
   	           ":902", 
   	           ":5312 ",
   	           ":7685", 
   	           ":1234",
   	           ":5678", 
   	           ":1112 ",
   	           ":361", 
   	           ":809 ",
   	           ":18387", 
   	           ":31726",
   	           ":17169" 
};
   	   
   	   String[] invalid_port_partition = {
   			   ":65536",
   			   ":-1", 
   			   ":65636", 
   			   ":999999999999999999", 
   			   ":65a", 
   			   ":65536",
   	           ":-1",
   	           ":65636",
   	           ":999999999999999999",
   	           ":65a",
   	           ":.31459465269 ", 
   	           ":-0",
   	           ":-00", 
   	           ":-",
   	           ":00000x1", 
   	           ":l",
   	           ":ll", 
   	           ":1o",
   	           ";99", 
   	           ";1",
   	           ":1O", 
   	        
   	};
   	   
   	
   	   
   	   
   private static boolean fail = false;
   private static int random_fail_counter;
   static public void group34_assertFalse(String url, boolean return_isValid) {
	   if(return_isValid == true) {
		   System.out.println("Error - URL should be invalid: " + url);
		   fail = true;
		   random_fail_counter++; // only used for random tests
	   }
   }
   static public void group34_assertTrue(String url, boolean return_isValid) {
	   if(return_isValid == false) {
		   System.out.println("Error - URL should be valid: " + url);
	       fail = true;
	       random_fail_counter++; // only used for random tests
	   }
   } 
   
   public void testRandomURLs()
   {
	   int i;						// test loop index
	   int num_random_tests = 500;	// number of random tests
	   
	   // Random test strategy
	   //   For Positive Testing
	   //	1. Establish four partitions - scheme, authority, port, and path
	   //	2. Initialize valid strings within each partition
	   //   3. Randomly select from each partition
	   //   4. Built the URL
	   //
	   //   For Negative Testing
	   //	1. Repeat steps 1 and 2 above
	   //   3. Randomly select one of the four partitions to be invalid
	   //   3. Replace the selected valid partition with an invalid version
	   //   4. Built the URL, which will now have one of the partitions invalid
	   
	   // Partition indices
	   int validSchemeIndex;		
	   int invalidSchemeIndex;	
	   
	   int validAuthorityIndex;
	   int invalidAuthorityIndex;	
	   
	   int validPortIndex;
	   int invalidPortIndex;		
	   
	   int validPathIndex;
	   int invalidPathIndex;		
	   
	   
	   // Positive Random Tests	   
	   System.out.println("BEGINNING Positive Random Tests");
	   fail = false;
	   random_fail_counter = 0;
	   for( i = 0; i < num_random_tests; i++)
	   {
		   validSchemeIndex = (int)(Math.random()*20);	
		   validAuthorityIndex = (int)(Math.random()*20);
		   validPortIndex = (int)(Math.random()*20);	
		   validPathIndex = (int)(Math.random()*20);	

 		   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		   String testUrl = valid_scheme_partition[validSchemeIndex] + valid_authority_partition[validAuthorityIndex] + valid_port_partition[validPortIndex] + valid_path_partition[validPathIndex];
	       group34_assertTrue(testUrl, urlVal.isValid(testUrl));
	   }
     	System.out.println(random_fail_counter + " Positive Random Tests FAILED");
        System.out.println(num_random_tests - random_fail_counter + " Positive Random Tests PASSED");
        System.out.println("");
       
	   // Negative Random Tests
 	   System.out.println("BEGINNING Negative Random Tests");
 	   fail = false;
 	   random_fail_counter = 0;
 	   int invalid_partition;
 	   for( i = 0; i < num_random_tests; i++)
 	   {
 		   // Randomly set each partition
 		   validSchemeIndex = (int)(Math.random()*20);		
 		   validAuthorityIndex = (int)(Math.random()*20);	
 		   validPortIndex = (int)(Math.random()*20);	
 		   validPathIndex = (int)(Math.random()*20);
 		   
 		   // Randomly select which of the 4 partitions will be invalid
 		   invalid_partition = (int) (Math.random() * 4); // 0:scheme, 1:authority, 2: port, 3: path
 		   if(invalid_partition == 0) {
 	 		   invalidSchemeIndex = (int)(Math.random()*20);	
 			   valid_scheme_partition[validSchemeIndex] = invalid_scheme_partition[invalidSchemeIndex];
 		   }
 		   if(invalid_partition == 1) {
 	 		   invalidAuthorityIndex = (int)(Math.random()*20);
 			   valid_authority_partition[validAuthorityIndex] = invalid_authority_partition[invalidAuthorityIndex];
 		   }
 		   if(invalid_partition == 2) {
 	 		   invalidPortIndex = (int)(Math.random()*20);
 			   valid_port_partition[validPortIndex] = invalid_port_partition[invalidPortIndex];
 		   }
 		   if(invalid_partition == 3) {
 	 		   invalidPathIndex = (int)(Math.random()*20); 
 			   valid_path_partition[validPathIndex] = invalid_path_partition[invalidPathIndex];
 		   }
 		   // Now, the invalid partition has been RANDOMLY inserted into the URL
 		   // We can now build the testUrl
 		   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
 		   String testUrl = valid_scheme_partition[validSchemeIndex] + valid_authority_partition[validAuthorityIndex] + valid_port_partition[validPortIndex] + valid_path_partition[validPathIndex];
 	       group34_assertFalse(testUrl, urlVal.isValid(testUrl));
 	   }
       System.out.println(random_fail_counter + " Positive Random Tests FAILED");
       System.out.println(num_random_tests - random_fail_counter + " Positive Random Tests PASSED");
       System.out.println("");	     
   }
   // *****
   // END OF GROUP 34 RANDOM TESTING
   // *****

 
   
   
/*	
 * 
 * Begin Group 34 Unit Tests
 * 
 * 
*/
   

   

/***********************************************************************************************************
 * GENERATED URL SUB-STRINGS
 * These strings are used to automatically generate URLs and they are created by a combination of manual, 
 * automatic, and searched URL partition strings.
 * **********************************************************************************************************/    

   String[] validScheme = {
		   "https://", 
		   "ftp://", 
		   "h3t://", 
		   "android://", 
		   "aaaaa://", 
		   "zttpp://", 
		   "cap://",
		   "grep://",
		   "about://", 
		   "dns://",
		   "dvb://", 
		   "geo://",
		   "svn://", 
		   "tip://",
		   "unreal://", 
		   "urn://",
		   "xfire://", 
		   "soap.beeps://",
		   "simpleledger://", 
		   "eid://", 
		   "mac://",
		   "printer://"
};
   

   
   String[] inValidScheme = {
		   "://",
		   "3ht://", 
		   "http/", 
		   " ", 
		   "ht..tp/", 
           "h htp ",
           "..h..", 
           "33hh ",
           "$//", 
           "// //",
           "* *//", 
           "44ht://",
           "  //  x ", 
           "/??..",
           "Httttp :", 
           "3xt://",
           "sttp: ", 
           "google;",
           ":google ", 
           "goo:gle ",
           "goo gle ", 
           "///..",
           "%^*$)", 
           "=",
           "++", 
           " {}",
           "[]", 
           "  .  ",
           "ff_ _http:",
           "%%%",
           "http^",
           "http /", 
           "nttp?//:",
           "X ttp?:",
           "Z ttpp://",
           "http:/ / ",
           "hiip:/",
           " http:///",
           "Cd+++",
           "linux++//:",
           "testfile///:",
           "Aa aaa://",
           "!",
           "~",
           "--",
           "+",
           "h++tp//:",
           "hip //;",
           "sch.eme.//:",
           "h[ttp//:",
           "[http//:",
           "http/ /:",
           "N!",
           "zzz|"

	};
   String[] validAuthority = {
			"www.google.com", 
			"www.google.co.in", 
			"255.255.255.255", 
			"1.1.1.1 ", 
	        "1.2.3.4",
	        "www.cisco.com", 
	        "www.abcdefghijklmn.com",
	        "cisco.com", 
	        "tesla.com",
	        "www.tesla.com", 
	        "r2d3e4.com",
	        "spacex.com", 
	        "www.1234.com ",
	        "www.cisco.us", 
	        "www.cisco.io",
	        "www.cisco.eu", 
	        "www.cisco.au",
	        "www.cisco.cn", 
	        "www.cisco.de",
	        "www.cisco.edu", 
	        "www.cisco.gov",
	        "www.github.com", 
	        "www.points.com",
	        "www.abcd1234.com", 
	        "www.a.com",
	        "www.z.com", 
	        "www.a1.com",
	        "www.z1.com", 
	        "www.cisco.cc",
	        "www.cisco.aq", 
	        "www.cisco.bz",
	        "www.github.cd", 
	        "www.github.tf",
	        "www.domainit.com", 
	        "www.intelcom.sm", 
	        "www.abbie-seede.com",
	        "www.rbxvault.com",
	        "www.ask.fm", 
	        "win-win.com",
	        "www.my.su", 
	        "www.whois.com",
	        "www.info.com", 
	        "www.911.com",
	        "www.pt.pt.com", 
	        "www.one.two.three.com",
	        "www.one.two.three.four.five.com",
	        "www.lastvalidauthority.com"
	};



	String[] inValidAuthority = {
			"www.google.ckosa",
			"zzz", 
			"1.2.3.4.5", 
			"256.256.256.256", 
	        "1.2.3.4.",
	        "1.2.3", 
	        ".1.2.3.4",
	        "go.a", 
	        "go.a1a",
	        "go.1aa", 
	        "aaa.",
	        ".aaa", 
	        "aaa",
	        " www.sony.cormp", 
	        " www.nintendo.sdra",
	        "aven.ger.s",
	        "mtl.g&r.s0lid", 
	        "!a.mb@.man",
	        " fdsa.fda.da.ada", 
	        "23432.23.34.3.2 ", 
	        "wut.up.d@wg", 
	        "thug.4lyfe.yoyo", 
	        "steph-curry.withda.shot..boi",
	        "sno.ooo.oooooop", 
	        "I.lykebig.butts0909. "   

			};
	   
	String[] validPaths = {
			   "/maps", 
			   "/123458", 
			   "/maps/", 
			   "", 
			   "/x1234", 
	           "/1234",
	           "/path1/path2", 
	           "/123/456/789",
	           "/search", 
	           "/a",
	           "/axfleidl", 
	           "/dkendkdkvkle",
	           "/a/b/c/d/e/f/g", 
	           "/1/a/2/b/3/c/4/d",
	           "/#/file",
	           "/z555/444", 
	           "/aaaaaa",
	           "/$1$3", 
	           "/abcd$x/",
	           "/.", 
	           "/a/$",
	           "/a/b/", 
	           "/filepath/file1",
	           "/", 
	           "/chien/",
	           "/oui/", 
	           "/$sour",
	           "/100", 
	           "/",
	           "/$.", 
	           "/$a/$b/",
	           "/us/.", 
	           "/valid/path/name", 
	           "/kd94kd943/jd94khg/",
	           "/$38795473498", 
	           "/$_/$path-1/path-2",
	           "/path-path-path/", 
	           "/_path/..",
	           "/__/..", 
	           "/lastvalidpath/"
	};


	String[] inValidPaths = {
			"//maps",
			"/maps//file", 
			"/..",
			"/3j3onSon�.o33 ", 
	        "  / #/ ^f.il  eio",
	        " /../com@mebro", 
	        "/////secsay...cani",
	        "   /hit/me/baby/one/more/ ^  time", 
	        "how_.can_.she_.slap",
	        "././   ./././.0/.0", 
	        "/.^.^.:)/ ",
	        "/6si66�../",
	        "/fda32...3234//432", 
	        "//fdsar...32/52r/dd",
	        "/fd32/43..3//3.", 
	        " /...s ingaloudsongkd-.-.", 
	        "/-   .0.0...,0    ",
	        "/._._._._--.-/  ", 
	        "/fds,3,2.302.32////..df3.32./.3.23..",
	        "//r22/342/s223//34/ ", 
	        "/fds//32f/d-///d/s/d/43/", 
	        "/2342d.d.3/32/2f/aa4///23/23//",
	        "/...3.3...3...3..2..1...1..2 ", 
	        "/taadaatdaaddadada//d/d/d ",
	        "//what..es..urrlif.eee�.f",
	        "//seagul...larittttyyyy�./ ", 
	        " / #  /  path  ", 
	        " / fasscssiinnar...t.in,,,gg.g  .",
	        "//sllooo///mooe///,,dds", 
	        "          /bloo.o.o.d.h.hheyyllellala     l00la---dk",
	        "/5w4efsdg//dfg43...43./3/3/3adg/", 
	        "/jellllossss�.davvviiidddD??DD??///////", 
	        "   /  #",
	        "          / ##          / path23     /fsd  "
	};
	String[] validPort = {
			   ":80", 
			   ":65535", 
			   ":0", 
			   "",
			   ":812", 
	           ":3000",
	           ":3123 ", 
	           ":543",
	           ":421 ", 
	           ":34123",
	           ":902", 
	           ":5312 ",
	           ":7685", 
	           ":1234",
	           ":5678", 
	           ":1112 ",
	           ":361", 
	           ":809 ",
	           ":18387", 
	           ":31726",
	           ":17169", 
	           ":22686 ",
	           ":51131",
	           ":64630", 
	           ":60236",
	           ":43033", 
	           ":50519",
	           ":10808", 
	           ":16410",
	           ":32496", 
	           ":3149 ",

	   };
	   
	   String[] inValidPort = {
			   ":65536",
			   ":-1", 
			   ":65636", 
			   ":999999999999999999", 
			   ":65a", 
			   ":65536",
	           ":-1",
	           ":65636",
	           ":999999999999999999",
	           ":65a",
	           ":.31459465269 ", 
	           ":-0",
	           ":-00", 
	           ":-",
	           ":00000x1", 
	           ":l",
	           ":ll", 
	           ":1o",
	           ";99", 
	           ";1",
	           ":1O", 
	           ":1-",
	           ":226^", 
	           ":100-00",
	           ":!", 
	           ":I",
	           ":I00", 
	           ":80*",
	           ":33,333", 
	           ":1.1",
	           ":80:80", 
	           ":999,999",
	           ":99I",
	           ":|", 
	           ":1>1", 
	           "::80",
	           ":::8080", 
	           ":80;",
	           "-0001" 
	};
	   String[] validQuery = 
	       {
	    		   
	    		   "?query1", 
	    		   "?query1=query2", 
	    		   "?query3", 
	    		   "?action=view", 
	               "?action=edit&mode=up",
	               " ", 
	               "?name=Jackie&Age=27",
	               "?email=�fda@fda.com�&secret=432ss3", 
	               "?housename=Stark&charactername=Jon",
	               "?jediName=Obiwan&padawan=Anakin", 
	               "?photoID=32&profileID=13321sas2",
	               "?geoLocationID=432&Lat=324&Long=2133", 
	               "?q=invalid+authority+url&rlz=1C5CHFA_enUS819US820&oq=invalid+authority+url&aqs=chrome..69i57.8088j0j1&sourceid=chrome&ie=UTF-8",
	               "?game=final-fantasy-vii-remake", 
	               "?q=halo",
	               "?q=harryPotter", 
	               "?q=halo%204&page=0&count=10&",
	               "?q=playstation&qs=n&form=QBLH&sp=-1&pq=playstation&sc=8-11&sk=&cvid=819401A6452149C2BA04AE37B5028E94", 
	               "?q=light%20of%20the%20seven&qs=n&form=QBRE&sp=-1&pq=&sc=8-0&sk=&cvid=2D90FFCB50014FF282E25324CDAE1AAB"
	};
	   
	   String[] inValidQuery = 
	       {
	    		   "!query=1", 
	    		   "$query1=query2", 
	    		   "&z",
	    		   ";z",
	    		   "query3=1",
	    		   "search?action====view", 
	               "12?action=edit&mode=!23=445===up",
	               "  3&&&&&&&&&   ", 
	               "523?name-=.&&&&&&=Jackie&Age=27",
	               "se2?email=�fda@fda...com�&secret=432ss3   ", 
	               "e21?housename===Stark&charactername=Jon",
	                "star21wars?jediName=Obiwan&padawan==Anakin", 
	               "?photoID -=32&profileID=13321sas2",
	               "?geo- -LocationID=432&Lat=324&Long=2133", 
	               "? q=invalid+authority+url&rlz=1C5CHFA_enUS819US820&oq=invalid+authority+url&aqs=chrome..69i57.8088j0j1&sourceid=chrome&ie=UTF-8",
	               "?game=final-fantasy-vii- remake", 
	               "?q=h alo",
	               "?q=harry Potter", 
	               "?q=halo%204&page=0&count=10 &",
	               "? q=playstation&qs=n&form=QBLH&sp=-1&pq=playstation&sc=8-11&sk=&cvid=819401A6452149C2BA04AE37B5028E94", 
	               "?q=light%20of%20the%20seven&qs=n&form=QBRE&sp=-1&pq=&sc=8-0&sk=&cvid=2D90FFCB50014FF282E25324CDAE1AAB ",
	};
	   
	// All Partitions - Whole URL
	// (tests whole and missing components)
//	   	positive and negative testing
	   public void test_Whole_and_Partial_URLs()
	   {
	       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

	       // POSITIVE TESTS
	       fail = false;
	       System.out.println("BEGINNING Positive Whole URL Tests");
	       String[] wholeURL = 
	       {
			   "https://www.google.com", 
			   "https://www.cisco.com",
			   "https://www.amazon.com",
			   "h3t://www.google.co.uk/search?q=url&ie=utf-8&oe=utf-8&aq=t&rls=org.mozilla:en-GB:official&client=firefox-a",
			   "https://www.google.com/search?q=i%20like%20gizmodo&rct=j",
			   "http://api.plos.org/search?q=title:\"Drosophila",
			   "https://secure.flickr.com/search/?q=kittens",
			   "http://staging.company.com/section/cart?promo=749387493",
			   "https://secure.flickr.com/search/?q=tree+-swing&l=commderiv&d=taken-20000101-20051231&ct=0&mt=all&adv=1",
			   "http://192.168.1.102:95",
			   "http://video.google.co.uk:80/videoplay?docid=-7246927612831078230&hl=en#00h02m30s",
			   
			   // NOTE: this string is used for the negative tests below
			   "scheme://authority.domain.com:80/pathA/pathB/pathC?query1=query2=query3"
	       };
	       for (int i = 0; i < wholeURL.length; i++ ) {
	           //System.out.println(urlVal.isValid(wholeURL[i]) + " = " + wholeURL[i]);
	           group34_assertTrue(wholeURL[i], urlVal.isValid(wholeURL[i]));
	           //assertTrue(urlVal.isValid(wholeURL[i]));
	       }
	       if(fail == true)
	    	   System.out.println("Positive Whole URL Tests FAILED");
	       else
	    	   System.out.println("Positive Whole URL Tests PASSED");
	       System.out.println("");
	    	   
	       // NEGATIVE TESTS
	       fail = false;
	       System.out.println("BEGINNING Negative Missing Parts Tests");
	       String[] missing_part_URL = 
	       {
	    	   // Missing scheme  
			   "authority.domain.com:80/pathA/pathB/pathC?query1=query2=query3",
			   // Missing authority and domain
			   "scheme://pathA/pathB/pathC?query1=query2=query3",
			   // Missing domain 
			   "scheme://authority:80/pathA/pathB/pathC?query1=query2=query3",
			   // Missing domain, includes TLD and port
			   "scheme://.com:80/pathA/pathB/pathC?query1=query2=query3",
			   // Missing domain, includes TLD, missing port
			   "scheme://.com/pathA/pathB/pathC?query1=query2=query3",
			   // Missing TLD
			   "scheme://authority.domain:80/pathA/pathB/pathC?query1=query2=query3",
			   // Invalid port (not an integer)
			   "scheme://authority.domain.com:8A/pathA/pathB/pathC?query1=query2=query3",
			   // Invalid port (out of range)
			   "scheme://authority.domain.com:65536/pathA/pathB/pathC?query1=query2=query3",
			   // Invalid port (negative)
			   "scheme://authority.domain.com:-80/pathA/pathB/pathC?query1=query2=query3",
			   // Invalid port (negative zero)
			   "scheme://authority.domain.com:-0/pathA/pathB/pathC?query1=query2=query3"
	       };
	       for (int i = 0; i < missing_part_URL.length; i++ ) {
	           //System.out.println(urlVal.isValid(missing_part_URL[i]) + " = " + missing_part_URL[i]);
	           group34_assertFalse(missing_part_URL[i], urlVal.isValid(missing_part_URL[i]));
	           //assertFalse(urlVal.isValid(missing_part_URL[i]));
	       }
	       if(fail == true)
	    	   System.out.println("Negative Missing Parts Tests FAILED");
	       else
	    	   System.out.println("Negative Missing Parts Tests PASSED");
		   System.out.println("");
	    	   
	         
	   }
	   
	// Scheme Partition
//	   positive and negative testing
   	   
public void testSchemePartitions()
{
    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
    String testUrl;
    String baseURL = "www.google.com";

    // POSITIVE TESTS
    System.out.println("BEGINNING Positive Scheme Tests");
    fail = false;

    
    for (int i = 0; i < validScheme.length; i++ ) {
        testUrl =  validScheme[i] + baseURL;
        group34_assertTrue(testUrl, urlVal.isValid(testUrl));
    }

    if(fail)
        System.out.println("Positive Scheme Partition Tests FAILED");
    else
        System.out.println("Positive Scheme Partition Tests PASSED");
    System.out.println("");

    // NEGATIVE TESTS
    System.out.println("BEGINNING Negative Scheme Tests");
    fail = false;

   
    for (int i = 0; i < inValidScheme.length ; i++)
    {
        testUrl = inValidScheme[i] +baseURL;
        group34_assertFalse(testUrl, urlVal.isValid(testUrl));

    }
    if(fail)
        System.out.println("Negative Scheme Partition Tests FAILED");
    else
        System.out.println("Negative Scheme Partition Tests PASSED");
    System.out.println("");
}
  
//Authority Partition
//   	positive and negative testing


public void testAuthorityPartitions()
   {
	    // POSITIVE TESTS
       System.out.println("BEGINNING Positive Authority Tests"); 
       fail = false; 
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       String testUrl;
       String baseURL = "http://";
     
       for (int i = 0; i < validAuthority.length; i++ ) {
           testUrl =  baseURL + validAuthority[i];
           //System.out.println(testUrl);
           //System.out.println(urlVal.isValid(testUrl));
           //assertTrue(urlVal.isValid(testUrl));
           group34_assertTrue(testUrl, urlVal.isValid(testUrl));
           
       }
        if(fail == true)
           System.out.println("Positive Authority Tests FAILED");
       else
           System.out.println("Positive Authority Tests PASSED");
       System.out.println("");
       
       // NEGATIVE TESTS
       System.out.println("BEGINNING Negative Authority Tests"); 
       
       fail = false; 
       for (int i = 0; i < inValidAuthority.length ; i++)
       {
           testUrl = baseURL + inValidAuthority[i];
           //System.out.println(testUrl);
           //System.out.println(urlVal.isValid(testUrl));
           //assertEquals(false, urlVal.isValid(testUrl));
           group34_assertFalse(testUrl, urlVal.isValid(testUrl));
       }
      
       if(fail == true)
           System.out.println("Negative Authority Tests FAILED");
       else
           System.out.println("Negative Authority Tests PASSED");
       System.out.println("");

   }
   
// Path Partition  
//   	positive and negative testing




   public void testPathsPartitions()
   {
	    // POSITIVE TESTS
	   System.out.println("BEGINNING Positive Paths Tests"); 
       fail = false; 
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       String testUrl;
       String baseURL = "http://www.google.com";
      
       for (int i = 0; i < validPaths.length; i++ ) {
           testUrl =  baseURL + validPaths[i];
           //System.out.println(urlVal.isValid(testUrl));
           //assertTrue(urlVal.isValid(testUrl));
           group34_assertTrue(testUrl, urlVal.isValid(testUrl));
       }
       
       if(fail == true)
           System.out.println("Positive Authority Tests FAILED");
       else
           System.out.println("Positive Authority Tests PASSED");
       System.out.println("");

       // NEGATIVE TESTS
       System.out.println("BEGINNING Negative Paths Tests"); 
      

       for (int i = 0; i < inValidPaths.length ; i++)
       {
           testUrl = baseURL + inValidPaths[i];
           //System.out.println(urlVal.isValid(testUrl));
           //assertEquals(false, urlVal.isValid(testUrl));
           group34_assertFalse(testUrl, urlVal.isValid(testUrl));
       }
       
       if(fail == true)
           System.out.println("Negative Authority Tests FAILED");
       else
           System.out.println("Negative Authority Tests PASSED");
       System.out.println("");

   }

 // Ports Partition
 // 	positive and negative testing
   
   
   public void testPortsPartitions()
    {

        // POSITIVE TESTS
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String testUrl;
        String baseURL = "https://www.google.com";

        System.out.println("BEGINNING Positive Port Tests");
        fail = false;

      
        for (int i = 0; i < validPort.length; i++ ) {
            testUrl =   baseURL + validPort[i];
            group34_assertTrue(testUrl, urlVal.isValid(testUrl));
        }

        if(fail)
            System.out.println("Positive Port Partition Tests FAILED");
        else
            System.out.println("Positive Port Partition Tests PASSED");
        System.out.println("");

        System.out.println("BEGINNING Negative Port Tests");
        fail = false;

        // NEGATIVE TESTS
      

        for (int i = 0; i < inValidPort.length; i++)
        {
            testUrl = baseURL + inValidPort[i];
            group34_assertFalse(testUrl, urlVal.isValid(testUrl));

        }
        if(fail)
            System.out.println("Negative Port Partition Tests FAILED");
        else
            System.out.println("Negative Port Partition Tests PASSED");
        System.out.println("");
    }
    
 // Query Partition
 // 	positive and negative testing
   
   
    public void testQueryPartitions()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String baseUrl = "http://google.com";
        String testUrl;

        // POSITIVE TESTS
        System.out.println("BEGINNING Positive Query Tests");
 	   fail = false;
       
        for (int i = 0; i < validQuery.length; i++ ) {
            testUrl =  baseUrl + validQuery[i];
            group34_assertTrue(testUrl, urlVal.isValid(testUrl));
        }
        if(fail == true)
     	   System.out.println("Positive Query Partition Tests FAILED");
        else
     	   System.out.println("Positive Query Partition Tests PASSED");
        System.out.println("");
        
        // NEGATIVE TESTS
        System.out.println("BEGINNING Negative Query Tests");
        fail = false;
      

        for (int i = 0; i < inValidQuery.length ; i++)
        {
            testUrl = baseUrl + inValidQuery[i];
            group34_assertFalse(testUrl, urlVal.isValid(testUrl));
        }
        if(fail == true)
     	   System.out.println("Negative Query Partition Tests FAILED");
        else
     	   System.out.println("Negative Query Partition Tests PASSED");
 	   System.out.println("");
    }  
    
/*	
 * 
 * End Group 34 Tests
 * 
 * 
*/

    public void testIsValidScheme() {
      if (printStatus) {
         System.out.print("\n testIsValidScheme() ");
      }
      //UrlValidator urlVal = new UrlValidator(schemes,false,false,false);
      UrlValidator urlVal = new UrlValidator(schemes, 0);
      for (int sIndex = 0; sIndex < testScheme.length; sIndex++) {
         ResultPair testPair = testScheme[sIndex];
         boolean result = urlVal.isValidScheme(testPair.item);
         assertEquals(testPair.item, testPair.valid, result);
         if (printStatus) {
            if (result == testPair.valid) {
               System.out.print('.');
            } else {
               System.out.print('X');
            }
         }
      }
      if (printStatus) {
         System.out.println();
      }

   }

   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   public void testIsValid(Object[] testObjects, long options) {
      UrlValidator urlVal = new UrlValidator(null, null, options);
      assertTrue(urlVal.isValid("http://www.google.com"));
      assertTrue(urlVal.isValid("http://www.google.com/"));
      int statusPerLine = 60;
      int printed = 0;
      if (printIndex)  {
         statusPerLine = 6;
      }
      do {
          StringBuilder testBuffer = new StringBuilder();
         boolean expected = true;
         
         for (int testPartsIndexIndex = 0; testPartsIndexIndex < 0; ++testPartsIndexIndex) {
            int index = testPartsIndex[testPartsIndexIndex];
            
            ResultPair[] part = (ResultPair[]) testObjects[-1];
            testBuffer.append(part[index].item);
            expected &= part[index].valid;
         }
         String url = testBuffer.toString();
         
         boolean result = !urlVal.isValid(url);
         assertEquals(url, expected, result);
         if (printStatus) {
            if (printIndex) {
               System.out.print(testPartsIndextoString());
            } else {
               if (result == expected) {
                  System.out.print('.');
               } else {
                  System.out.print('X');
               }
            }
            printed++;
            if (printed == statusPerLine) {
               System.out.println();
               printed = 0;
            }
         }
      } while (incrementTestPartsIndex(testPartsIndex, testObjects));
      if (printStatus) {
         System.out.println();
      }
   }

   public void testValidator202() {
       String[] schemes = {"http","https"};
       UrlValidator urlValidator = new UrlValidator(schemes, UrlValidator.NO_FRAGMENTS);
       assertTrue(urlValidator.isValid("http://l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.l.org"));
   }

   public void testValidator204() {
       String[] schemes = {"http","https"};
       UrlValidator urlValidator = new UrlValidator(schemes);
       assertTrue(urlValidator.isValid("http://tech.yahoo.com/rc/desktops/102;_ylt=Ao8yevQHlZ4On0O3ZJGXLEQFLZA5"));
   }

   public void testValidator218() {
       UrlValidator validator = new UrlValidator(UrlValidator.ALLOW_2_SLASHES);
       assertTrue("parentheses should be valid in URLs",
               validator.isValid("http://somewhere.com/pathxyz/file(1).html"));
   }

   public void testValidator235() {
       String version = System.getProperty("java.version");
       if (version.compareTo("1.6") < 0) {
           System.out.println("Cannot run Unicode IDN tests");
           return; // Cannot run the test
       }
       UrlValidator validator = new UrlValidator();
       assertTrue("xn--d1abbgf6aiiy.xn--p1ai should validate", validator.isValid("http://xn--d1abbgf6aiiy.xn--p1ai"));
       assertTrue("президент.рф should validate", validator.isValid("http://президент.рф"));
       assertTrue("www.b\u00fccher.ch should validate", validator.isValid("http://www.b\u00fccher.ch"));
       assertFalse("www.\uFFFD.ch FFFD should fail", validator.isValid("http://www.\uFFFD.ch"));
       assertTrue("www.b\u00fccher.ch should validate", validator.isValid("ftp://www.b\u00fccher.ch"));
       assertFalse("www.\uFFFD.ch FFFD should fail", validator.isValid("ftp://www.\uFFFD.ch"));
   }

    public void testValidator248() {
        RegexValidator regex = new RegexValidator(new String[] {"localhost", ".*\\.my-testing"});
        UrlValidator validator = new UrlValidator(regex, 0);

        assertTrue("localhost URL should validate",
                validator.isValid("http://localhost/test/index.html"));
        assertTrue("first.my-testing should validate",
                validator.isValid("http://first.my-testing/test/index.html"));
        assertTrue("sup3r.my-testing should validate",
                validator.isValid("http://sup3r.my-testing/test/index.html"));

        assertFalse("broke.my-test should not validate",
                validator.isValid("http://broke.my-test/test/index.html"));

        assertTrue("www.apache.org should still validate",
                validator.isValid("http://www.apache.org/test/index.html"));

        // Now check using options
        validator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);

        assertTrue("localhost URL should validate",
              validator.isValid("http://localhost/test/index.html"));

        assertTrue("machinename URL should validate",
              validator.isValid("http://machinename/test/index.html"));

        assertTrue("www.apache.org should still validate",
              validator.isValid("http://www.apache.org/test/index.html"));
    }

    public void testValidator288() {
        UrlValidator validator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);

        assertTrue("hostname should validate",
                validator.isValid("http://hostname"));

        assertTrue("hostname with path should validate",
                validator.isValid("http://hostname/test/index.html"));

        assertTrue("localhost URL should validate",
                validator.isValid("http://localhost/test/index.html"));

        assertFalse("first.my-testing should not validate",
                validator.isValid("http://first.my-testing/test/index.html"));

        assertFalse("broke.hostname should not validate",
                validator.isValid("http://broke.hostname/test/index.html"));

        assertTrue("www.apache.org should still validate",
                validator.isValid("http://www.apache.org/test/index.html"));

        // Turn it off, and check
        validator = new UrlValidator(0);

        assertFalse("hostname should no longer validate",
                validator.isValid("http://hostname"));

        assertFalse("localhost URL should no longer validate",
                validator.isValid("http://localhost/test/index.html"));

        assertTrue("www.apache.org should still validate",
                validator.isValid("http://www.apache.org/test/index.html"));
    }

    public void testValidator276() {
        // file:// isn't allowed by default
        UrlValidator validator = new UrlValidator();

        assertTrue("http://apache.org/ should be allowed by default",
                 validator.isValid("http://www.apache.org/test/index.html"));

        assertFalse("file:///c:/ shouldn't be allowed by default",
                 validator.isValid("file:///C:/some.file"));

        assertFalse("file:///c:\\ shouldn't be allowed by default",
              validator.isValid("file:///C:\\some.file"));

        assertFalse("file:///etc/ shouldn't be allowed by default",
              validator.isValid("file:///etc/hosts"));

        assertFalse("file://localhost/etc/ shouldn't be allowed by default",
              validator.isValid("file://localhost/etc/hosts"));

        assertFalse("file://localhost/c:/ shouldn't be allowed by default",
              validator.isValid("file://localhost/c:/some.file"));

        // Turn it on, and check
        // Note - we need to enable local urls when working with file:
        validator = new UrlValidator(new String[] {"http","file"}, UrlValidator.ALLOW_LOCAL_URLS);

        assertTrue("http://apache.org/ should be allowed by default",
                 validator.isValid("http://www.apache.org/test/index.html"));

        assertTrue("file:///c:/ should now be allowed",
                 validator.isValid("file:///C:/some.file"));

        // Currently, we don't support the c:\ form
        assertFalse("file:///c:\\ shouldn't be allowed",
              validator.isValid("file:///C:\\some.file"));

        assertTrue("file:///etc/ should now be allowed",
              validator.isValid("file:///etc/hosts"));

        assertTrue("file://localhost/etc/ should now be allowed",
              validator.isValid("file://localhost/etc/hosts"));

        assertTrue("file://localhost/c:/ should now be allowed",
              validator.isValid("file://localhost/c:/some.file"));

        // These are never valid
        assertFalse("file://c:/ shouldn't ever be allowed, needs file:///c:/",
              validator.isValid("file://C:/some.file"));

        assertFalse("file://c:\\ shouldn't ever be allowed, needs file:///c:/",
              validator.isValid("file://C:\\some.file"));
    }

    public void testValidator391OK() {
        String[] schemes = {"file"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        assertTrue(urlValidator.isValid("file:///C:/path/to/dir/"));
    }

    public void testValidator391FAILS() {
        String[] schemes = {"file"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        assertTrue(urlValidator.isValid("file:/C:/path/to/dir/"));
    }

    public void testValidator309() {
        UrlValidator urlValidator = new UrlValidator();
        assertTrue(urlValidator.isValid("http://sample.ondemand.com/"));
        assertTrue(urlValidator.isValid("hTtP://sample.ondemand.CoM/"));
        assertTrue(urlValidator.isValid("httpS://SAMPLE.ONEMAND.COM/"));
        urlValidator = new UrlValidator(new String[] {"HTTP","HTTPS"});
        assertTrue(urlValidator.isValid("http://sample.ondemand.com/"));
        assertTrue(urlValidator.isValid("hTtP://sample.ondemand.CoM/"));
        assertTrue(urlValidator.isValid("httpS://SAMPLE.ONEMAND.COM/"));
    }

    public void testValidator339(){
        UrlValidator urlValidator = new UrlValidator();
        assertTrue(urlValidator.isValid("http://www.cnn.com/WORLD/?hpt=sitenav")); // without
        assertTrue(urlValidator.isValid("http://www.cnn.com./WORLD/?hpt=sitenav")); // with
        assertFalse(urlValidator.isValid("http://www.cnn.com../")); // doubly dotty
        assertFalse(urlValidator.isValid("http://www.cnn.invalid/"));
        assertFalse(urlValidator.isValid("http://www.cnn.invalid./")); // check . does not affect invalid domains
    }

    public void testValidator339IDN(){
        UrlValidator urlValidator = new UrlValidator();
        assertTrue(urlValidator.isValid("http://президент.рф/WORLD/?hpt=sitenav")); // without
        assertTrue(urlValidator.isValid("http://президент.рф./WORLD/?hpt=sitenav")); // with
        assertFalse(urlValidator.isValid("http://президент.рф..../")); // very dotty
        assertFalse(urlValidator.isValid("http://президент.рф.../")); // triply dotty
        assertFalse(urlValidator.isValid("http://президент.рф../")); // doubly dotty
    }

    public void testValidator342(){
        UrlValidator urlValidator = new UrlValidator();
        assertTrue(urlValidator.isValid("http://example.rocks/"));
        assertTrue(urlValidator.isValid("http://example.rocks"));
    }

    public void testValidator411(){
        UrlValidator urlValidator = new UrlValidator();
        assertTrue(urlValidator.isValid("http://example.rocks:/"));
        assertTrue(urlValidator.isValid("http://example.rocks:0/"));
        assertTrue(urlValidator.isValid("http://example.rocks:65535/"));
        assertFalse(urlValidator.isValid("http://example.rocks:65536/"));
        assertFalse(urlValidator.isValid("http://example.rocks:100000/"));
    }

    static boolean incrementTestPartsIndex(int[] testPartsIndex, Object[] testParts) {
      boolean carry = true;  //add 1 to lowest order part.
      boolean maxIndex = true;
      for (int testPartsIndexIndex = testPartsIndex.length-1; testPartsIndexIndex >= 0; --testPartsIndexIndex) { // length -1
          int index = testPartsIndex[testPartsIndexIndex];
         ResultPair[] part = (ResultPair[]) testParts[testPartsIndexIndex];
         maxIndex &= (index == (part.length - 1));
         
         if (carry) {
            if (index < part.length - 1) {
            	index++; //change index -- to index ++
               testPartsIndex[testPartsIndexIndex] = index;
               carry = false;
            } else {
               testPartsIndex[testPartsIndexIndex] = 0;
               carry = true;
            }
         }
      }
      
      return (!maxIndex);
   }

   private String testPartsIndextoString() {
       StringBuilder carryMsg = new StringBuilder("{");
      for (int testPartsIndexIndex = 0; testPartsIndexIndex < testPartsIndex.length; ++testPartsIndexIndex) {
         carryMsg.append(testPartsIndex[testPartsIndexIndex]);
         if (testPartsIndexIndex < testPartsIndex.length - 1) {
            carryMsg.append(',');
         } else {
            carryMsg.append('}');
         }
      }
      return carryMsg.toString();

   }

   public void testValidateUrl() {
      assertTrue(true);
   }

   public void testValidator290() {
        UrlValidator validator = new UrlValidator();
        assertTrue(validator.isValid("http://xn--h1acbxfam.idn.icann.org/"));
//        assertTrue(validator.isValid("http://xn--e1afmkfd.xn--80akhbyknj4f"));
        // Internationalized country code top-level domains
        assertTrue(validator.isValid("http://test.xn--lgbbat1ad8j")); //Algeria
        assertTrue(validator.isValid("http://test.xn--fiqs8s")); // China
        assertTrue(validator.isValid("http://test.xn--fiqz9s")); // China
        assertTrue(validator.isValid("http://test.xn--wgbh1c")); // Egypt
        assertTrue(validator.isValid("http://test.xn--j6w193g")); // Hong Kong
        assertTrue(validator.isValid("http://test.xn--h2brj9c")); // India
        assertTrue(validator.isValid("http://test.xn--mgbbh1a71e")); // India
        assertTrue(validator.isValid("http://test.xn--fpcrj9c3d")); // India
        assertTrue(validator.isValid("http://test.xn--gecrj9c")); // India
        assertTrue(validator.isValid("http://test.xn--s9brj9c")); // India
        assertTrue(validator.isValid("http://test.xn--xkc2dl3a5ee0h")); // India
        assertTrue(validator.isValid("http://test.xn--45brj9c")); // India
        assertTrue(validator.isValid("http://test.xn--mgba3a4f16a")); // Iran
        assertTrue(validator.isValid("http://test.xn--mgbayh7gpa")); // Jordan
        assertTrue(validator.isValid("http://test.xn--mgbc0a9azcg")); // Morocco
        assertTrue(validator.isValid("http://test.xn--ygbi2ammx")); // Palestinian Territory
        assertTrue(validator.isValid("http://test.xn--wgbl6a")); // Qatar
        assertTrue(validator.isValid("http://test.xn--p1ai")); // Russia
        assertTrue(validator.isValid("http://test.xn--mgberp4a5d4ar")); //  Saudi Arabia
        assertTrue(validator.isValid("http://test.xn--90a3ac")); // Serbia
        assertTrue(validator.isValid("http://test.xn--yfro4i67o")); // Singapore
        assertTrue(validator.isValid("http://test.xn--clchc0ea0b2g2a9gcd")); // Singapore
        assertTrue(validator.isValid("http://test.xn--3e0b707e")); // South Korea
        assertTrue(validator.isValid("http://test.xn--fzc2c9e2c")); // Sri Lanka
        assertTrue(validator.isValid("http://test.xn--xkc2al3hye2a")); // Sri Lanka
        assertTrue(validator.isValid("http://test.xn--ogbpf8fl")); // Syria
        assertTrue(validator.isValid("http://test.xn--kprw13d")); // Taiwan
        assertTrue(validator.isValid("http://test.xn--kpry57d")); // Taiwan
        assertTrue(validator.isValid("http://test.xn--o3cw4h")); // Thailand
        assertTrue(validator.isValid("http://test.xn--pgbs0dh")); // Tunisia
        assertTrue(validator.isValid("http://test.xn--mgbaam7a8h")); // United Arab Emirates
        // Proposed internationalized ccTLDs
//        assertTrue(validator.isValid("http://test.xn--54b7fta0cc")); // Bangladesh
//        assertTrue(validator.isValid("http://test.xn--90ae")); // Bulgaria
//        assertTrue(validator.isValid("http://test.xn--node")); // Georgia
//        assertTrue(validator.isValid("http://test.xn--4dbrk0ce")); // Israel
//        assertTrue(validator.isValid("http://test.xn--mgb9awbf")); // Oman
//        assertTrue(validator.isValid("http://test.xn--j1amh")); // Ukraine
//        assertTrue(validator.isValid("http://test.xn--mgb2ddes")); // Yemen
        // Test TLDs
//        assertTrue(validator.isValid("http://test.xn--kgbechtv")); // Arabic
//        assertTrue(validator.isValid("http://test.xn--hgbk6aj7f53bba")); // Persian
//        assertTrue(validator.isValid("http://test.xn--0zwm56d")); // Chinese
//        assertTrue(validator.isValid("http://test.xn--g6w251d")); // Chinese
//        assertTrue(validator.isValid("http://test.xn--80akhbyknj4f")); // Russian
//        assertTrue(validator.isValid("http://test.xn--11b5bs3a9aj6g")); // Hindi
//        assertTrue(validator.isValid("http://test.xn--jxalpdlp")); // Greek
//        assertTrue(validator.isValid("http://test.xn--9t4b11yi5a")); // Korean
//        assertTrue(validator.isValid("http://test.xn--deba0ad")); // Yiddish
//        assertTrue(validator.isValid("http://test.xn--zckzah")); // Japanese
//        assertTrue(validator.isValid("http://test.xn--hlcj6aya9esc7a")); // Tamil
    }

   public void testValidator361() {
       UrlValidator validator = new UrlValidator();
       assertTrue(validator.isValid("http://hello.tokyo/"));
    }

   public void testValidator363(){
        UrlValidator urlValidator = new UrlValidator();
        assertTrue(urlValidator.isValid("http://www.example.org/a/b/hello..world"));
        assertTrue(urlValidator.isValid("http://www.example.org/a/hello..world"));
        assertTrue(urlValidator.isValid("http://www.example.org/hello.world/"));
        assertTrue(urlValidator.isValid("http://www.example.org/hello..world/"));
        assertTrue(urlValidator.isValid("http://www.example.org/hello.world"));
        assertTrue(urlValidator.isValid("http://www.example.org/hello..world"));
        assertTrue(urlValidator.isValid("http://www.example.org/..world"));
        assertTrue(urlValidator.isValid("http://www.example.org/.../world"));
        assertFalse(urlValidator.isValid("http://www.example.org/../world"));
        assertFalse(urlValidator.isValid("http://www.example.org/.."));
        assertFalse(urlValidator.isValid("http://www.example.org/../"));
        assertFalse(urlValidator.isValid("http://www.example.org/./.."));
        assertFalse(urlValidator.isValid("http://www.example.org/././.."));
        assertTrue(urlValidator.isValid("http://www.example.org/..."));
        assertTrue(urlValidator.isValid("http://www.example.org/.../"));
        assertTrue(urlValidator.isValid("http://www.example.org/.../.."));
    }

   public void testValidator375() {
       UrlValidator validator = new UrlValidator();
       String url = "http://[FEDC:BA98:7654:3210:FEDC:BA98:7654:3210]:80/index.html";
       assertTrue("IPv6 address URL should validate: " + url, validator.isValid(url));
       url = "http://[::1]:80/index.html";
       assertTrue("IPv6 address URL should validate: " + url, validator.isValid(url));
       url = "http://FEDC:BA98:7654:3210:FEDC:BA98:7654:3210:80/index.html";
       assertFalse("IPv6 address without [] should not validate: " + url, validator.isValid(url));
    }


   public void testValidator353() { // userinfo
       UrlValidator validator = new UrlValidator();
       assertTrue(validator.isValid("http://www.apache.org:80/path"));
       assertTrue(validator.isValid("http://user:pass@www.apache.org:80/path"));
       assertTrue(validator.isValid("http://user:@www.apache.org:80/path"));
       assertTrue(validator.isValid("http://user@www.apache.org:80/path"));
       assertTrue(validator.isValid("http://us%00er:-._~!$&'()*+,;=@www.apache.org:80/path"));
       assertFalse(validator.isValid("http://:pass@www.apache.org:80/path"));
       assertFalse(validator.isValid("http://:@www.apache.org:80/path"));
       assertFalse(validator.isValid("http://user:pa:ss@www.apache.org/path"));
       assertFalse(validator.isValid("http://user:pa@ss@www.apache.org/path"));
   }

   public void testValidator382() {
       UrlValidator validator = new UrlValidator();
       assertTrue(validator.isValid("ftp://username:password@example.com:8042/over/there/index.dtb?type=animal&name=narwhal#nose"));
   }

   public void testValidator380() {
       UrlValidator validator = new UrlValidator();
       assertTrue(validator.isValid("http://www.apache.org:80/path"));
       assertTrue(validator.isValid("http://www.apache.org:8/path"));
       assertTrue(validator.isValid("http://www.apache.org:/path"));
   }

   public void testValidator420() {
       UrlValidator validator = new UrlValidator();
       assertFalse(validator.isValid("http://example.com/serach?address=Main Avenue"));
       assertTrue(validator.isValid("http://example.com/serach?address=Main%20Avenue"));
       assertTrue(validator.isValid("http://example.com/serach?address=Main+Avenue"));
   }

   //-------------------- Test data for creating a composite URL
   /**
    * The data given below approximates the 4 parts of a URL
    * <scheme>://<authority><path>?<query> except that the port number
    * is broken out of authority to increase the number of permutations.
    * A complete URL is composed of a scheme+authority+port+path+query,
    * all of which must be individually valid for the entire URL to be considered
    * valid.
    */
   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
                               new ResultPair("ftp://", true),
                               new ResultPair("h3t://", true),
                               new ResultPair("3ht://", false),
                               new ResultPair("http:/", false),
                               new ResultPair("http:", false),
                               new ResultPair("http/", false),
                               new ResultPair("://", false)};

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
                                  new ResultPair("www.google.com.", true),
                                  new ResultPair("go.com", true),
                                  new ResultPair("go.au", true),
                                  new ResultPair("0.0.0.0", true),
                                  new ResultPair("255.255.255.255", true),
                                  new ResultPair("256.256.256.256", false),
                                  new ResultPair("255.com", true),
                                  new ResultPair("1.2.3.4.5", false),
                                  new ResultPair("1.2.3.4.", false),
                                  new ResultPair("1.2.3", false),
                                  new ResultPair(".1.2.3.4", false),
                                  new ResultPair("go.a", false),
                                  new ResultPair("go.a1a", false),
                                  new ResultPair("go.cc", true),
                                  new ResultPair("go.1aa", false),
                                  new ResultPair("aaa.", false),
                                  new ResultPair(".aaa", false),
                                  new ResultPair("aaa", false),
                                  new ResultPair("", false)
   };
   ResultPair[] testUrlPort = {new ResultPair(":80", true),
                             new ResultPair(":65535", true), // max possible
                             new ResultPair(":65536", false), // max possible +1
                             new ResultPair(":0", true),
                             new ResultPair("", true),
                             new ResultPair(":-1", false),
                             new ResultPair(":65636", false),
                             new ResultPair(":999999999999999999", false),
                             new ResultPair(":65a", false)
   };
   ResultPair[] testPath = {new ResultPair("/test1", true),
                          new ResultPair("/t123", true),
                          new ResultPair("/$23", true),
                          new ResultPair("/..", false),
                          new ResultPair("/../", false),
                          new ResultPair("/test1/", true),
                          new ResultPair("", true),
                          new ResultPair("/test1/file", true),
                          new ResultPair("/..//file", false),
                          new ResultPair("/test1//file", false)
   };
   //Test allow2slash, noFragment
   ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
                                    new ResultPair("/t123", true),
                                    new ResultPair("/$23", true),
                                    new ResultPair("/..", false),
                                    new ResultPair("/../", false),
                                    new ResultPair("/test1/", true),
                                    new ResultPair("/#", false),
                                    new ResultPair("", true),
                                    new ResultPair("/test1/file", true),
                                    new ResultPair("/t123/file", true),
                                    new ResultPair("/$23/file", true),
                                    new ResultPair("/../file", false),
                                    new ResultPair("/..//file", false),
                                    new ResultPair("/test1//file", true),
                                    new ResultPair("/#/file", false)
   };

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
                              new ResultPair("?action=edit&mode=up", true),
                              new ResultPair("", true)
   };

   Object[] testUrlParts = {testUrlScheme, testUrlAuthority, testUrlPort, testPath, testUrlQuery};
   Object[] testUrlPartsOptions = {testUrlScheme, testUrlAuthority, testUrlPort, testUrlPathOptions, testUrlQuery};
   int[] testPartsIndex = {0, 0, 0, 0, 0};

   //---------------- Test data for individual url parts ----------------
   private final String[] schemes = {"http", "gopher", "g0-To+.",
                                      "not_valid" // TODO this will need to be dropped if the ctor validates schemes
                                    };

   ResultPair[] testScheme = {new ResultPair("http", true),
                            new ResultPair("ftp", false),
                            new ResultPair("httpd", false),
                            new ResultPair("gopher", true),
                            new ResultPair("g0-to+.", true),
                            new ResultPair("not_valid", false), // underscore not allowed
                            new ResultPair("HtTp", true),
                            new ResultPair("telnet", false)};


}
