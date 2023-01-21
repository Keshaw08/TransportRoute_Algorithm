import java.util.*;

class dijkstraForPath1 {
    public static final int NO_PARENT = -1;
    static double desti_distance=0;
    static int ct =0;
    public static void dijkstra(double[][] adjacencyMatrix, int startVertex, int destination, String[] arr) {
        int nVertices = adjacencyMatrix[0].length;
        double[] shortestDistances = new double[nVertices];
 
        boolean[] added = new boolean[nVertices];
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++){
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
         
        shortestDistances[startVertex] = 0;
        int[] parents = new int[nVertices];
        
        parents[startVertex] = NO_PARENT;
        
        for (int i = 1; i < nVertices; i++){
 
            int nearestVertex = -1;
            double shortestDistance = Double.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)  {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
            
            added[nearestVertex] = true;
            
            for (int vertexIndex = 0; vertexIndex < nVertices;  vertexIndex++){
                double edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
                 
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])){
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }
        printSolution(startVertex, destination,shortestDistances, parents, arr);
        desti_distance = distance(destination, shortestDistances);
    }
   
    private static void printSolution(int startVertex, int destination, double[] distances, int[] parents, String[] arr){
        int nVertices = distances.length;
        System.out.println("==================================================XXXXXX=================================================");
        System.out.print("\nSource: ");
        System.out.println(arr[startVertex]);
        System.out.print("Destination: ");
        System.out.println(arr[destination]);
        System.out.print("\nDistance (Km): ");
        System.out.println(distances[destination] + " Km"+"\n");
        System.out.print("Path: ");
        printPath(destination, parents, arr);
        System.out.println("\n"+"\n=================================================XXXXXX==================================================");
    }
 
    public static double distance(int destination,double[] distances) {
    	return distances[destination];
    }
   
    private static void printPath(int currentVertex, int[] parents, String[] arr) {
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents, arr);
        System.out.print("-> ");
        System.out.print(arr[currentVertex] + " ");
    }
    
  public static int numberOfVehicle(int[] arr, int num) {
	  int cost=0;
		for(int i=0; i<arr.length; i++){
	    	int count=0;
	    	int check = num/arr[i];
	    	if(check >= 1) {
	    		
	    		num = num - check*arr[i];
	        	if(num >= arr[i]/1.5) {
	        		ct = num;
	        		count++;
	        		count = count + check;
	        		System.out.println();
	        		System.out.println("\nYou will require -> "+count + " Vehicle of Capacity (Kg) : " +arr[i]);
	        		cost = cost +(int) (count*((desti_distance/4)*90));
	        		break;
	        	}
	        	
	        	else {
	        		System.out.println("You will require -> "+check + " Vehicle of Capacity (Kg) : " +arr[i]+"\n");
	        		if(arr[i] == 15000) {
	        			cost = cost + (int) (check*((desti_distance/4)*90));
	        		}
	        		else if(arr[i] == 7000) {
	        			cost = cost +(int) (check*((desti_distance/13)*90));
	        		}
	        		else if(arr[i] == 2000) {
	        			cost = cost +(int) (check*((desti_distance/17)*90));
	        		}
	        		else {
	        			cost = cost +(int) (check*((desti_distance/23)*90));
	        		}
	        	}
	    	}
	    }
		System.out.println("\nTotal cost for delivery : "+cost+" Rs");
		return ct;
  	}
}

public class TransportRoute_Algorithm {
	public static void main(String[] args){	
		Scanner scan = new Scanner(System.in);
		
		String district_Raj[] = {"Ajmer","Alwar","Banswara",	"Barmer",	"Bharatpur",	"Bhilwada",	"Bikaner",	"Bundi",	"Chittorgarh",	"Churu",	"Dholpur",	"Dungarpur",	"SriGanganagar",	"Jaipur",	"Jaisalmer",	"Jalore",	"Jhalawar",	"Jhunjhunu",	"Jodhpur",	"Kota",	"Nagaur",	"Pali",	"Sikar",	"Sirohi",	"SawaiMadhopur",	"Tonk",	"Udaipur",	"Baran",	"Dausa",	"Rajsamand",	"Hanumangarh",	"Karauli",	"Paratapgarh"};
		
		int start = 1;
        int dest = 1;

        char ch ,ch1;
        int arr[] = {15000,7000,2000,1000};
        
        do {
        System.out.println("..TransportRoute_Algorithm..\n");
		System.out.println("Enter the Weight to be Transported : ");
		int weight = scan.nextInt();
		String source="";
		System.out.println("Enter the Warehouse");
		System.out.println("1. Jaipur\n2. Udaipur\n3. Jaisalmer");
		
		int choice = scan.nextInt();
		switch(choice) {
			case 1:{
				source = "Jaipur";
				for(int i=0;i<district_Raj.length;i++) {
			      	if(district_Raj[i].equals(source)) start = i;}
				break;
			}
			case 2:{
				source = "Udaipur";
				for(int i=0;i<district_Raj.length;i++) {
			      	if(district_Raj[i].equals(source)) start = i;}
				break;
			}
			case 3:{
				source = "Jaisalmer";
				for(int i=0;i<district_Raj.length;i++) {
			      	if(district_Raj[i].equals(source)) start = i;}
				break;
			}
		}
        System.out.println("Enter the Destination : ");
        String destination = scan.next();
        
        for(int i=0;i<district_Raj.length;i++) {
        	if(district_Raj[i].equals(destination)) dest = i;
        }
        //data for Rajsthan.
        double[][] adjacencyMatrix = {
        		{0,	0,	0,	0,	0,	135,	0,	165,	0,	0,	0,	0,	489,	135,	0,	0,	0,	0,	220,	0,	148,	168,	172,	306,	0,	175,	263,	0,	0,	204,	419,	0,	0},
        		{0,	0,	0,	0,	114,	0,	434,	0,	0,	0,	0,	0,	483,	159,	0,	0,	0,	173,	0,	0,	384,	0,	213,	0,	0,	230,	0,	0,	97,	509,	393,	150,	0},
        		{0,	0,	0,	0,	779,	0,	0,	301,	216,	0,	0,	0,	0,	550,	0,	0,	293,	0,	0,	0,	0,	0,	0,	0,	0,	0,	156,	0,	0,	255,	0,	0,	80},
        		{0,	0,	0,	0,	0,	409,	422,	541,	0,	0,	0,	0,	658,	0,	157,	157,	0,	0,	197,	0,	349,	221,	556,	206,	0,	548,	400,	0,	0,	341,	660,	0,	0},
        		{0,	114,	779,	0,	0,	0,	0,	0,	0,	0,	85,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	198,	0,	0,	0,	126,	0,	0,	111,	0},
        		{135,	0,	0,	409,	0,	0,	0,	147,	58,	0,	0,	0,	623,	247,	0,	263,	228,	0,	226,	158,	278,	175,	0,	0,	235,	176,	0,	0,	0,	91,	622,	338,	0},
        		{0,	434,	0,	422,	0,	0,	0,	0,	0,	181,	0,	0,	242,	337,	331,	403,	0,	220,	251,	0,	119,	317,	218,	0,	0,	0,	0,	0,	392,	0,	2332,	0,	0},
        		{165,	0,	301,	541,	0,	147,	0,	0,	186,	380,	0,	361,	663,	277,	0,	0,	125,	0,	357,	39,	356,	305,	293,	0,	136,	114,	264,	108,	0,	239,	0,	0,	213},
        		{0,	0,	216,	0,	0,	58,	0,	186,	0,	0,	567,	215,	0,	310,	0,	273,	210,	0,	0,	172,	0,	0,	367,	233,	0,	235,	111,	246,	0,	102,	624,	0,	108},
        		{0,	0,	0,	0,	0,	0,	181,	380,	0,	0,	0,	0,	270,	0,	534,	0,	0,	51,	414,	0,	197,	397,	89,	0,	0,	0,	0,	0,	0,	0,	200,	0,	0},
        		{0,	0,	0,	0,	85,	0,	0,	0,	567,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	268,	0,	303,	0,	0,	632,	107,	0},
        		{0,	0,	0,	0,	0,	0,	0,	361,	215,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	205,	0,	0,	105,	0,	0,	0,	0,	0,	144},
        		{489,	483,	0,	658,	0,	623,	242,	663,	0,	270,	0,	0,	0,	0,	517,	638,	0,	351,	0,	0,	413,	0,	352,	0,	0,	671,	0,	0,	587,	0,	69,	0,	0},
        		{135,	159,	550,	0,	0,	247,	337,	277,	310,	0,	0,	0,	0,	0,	0,	0,	0,	179,	0,	0,	235,	0,	114,	0,	145,	101,	0,	0,	59,	0,	0,	172,	0},
        		{0,	0,	0,	157,	0,	0,	331,	0,	0,	534,	0,	0,	517,	0,	0,	322,	0,	0,	281,	0,	323,	0,	495,	0,	0,	0,	0,	0,	0,	0,	511,	0,	0},
        		{0,	0,	0,	157,	0,	263,	403,	0,	273,	0,	0,	0,	638,	0,	322,	0,	0,	0,	133,	0,	289,	101,	0,	70,	0,	0,	199,	0,	567,	169,	0,	0,	0},
        		{0,	0,	293,	0,	0,	228,	0,	125,	210,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	89,	0,	0,	0,	433,	246,	0,	306,	83,	0,	0,	0,	0,	190},
        		{0,	173,	0,	0,	0,	0,	220,	0,	0,	51,	0,	0,	351,	179,	0,	0,	0,	0,	0,	0,	215,	406,	70,	0,	0,	0,	0,	0,	204,	0,	283,	0,	0},
        		{220,	0,	0,	197,	0,	226,	251,	357,	0,	414,	0,	0,	0,	0,	281,	133,	0,	0,	0,	383,	144,	66,	316,	196,	0,	354,	255,	0,	0,	196,	490,	0,	0},
        		{0,	0,	0,	0,	0,	158,	0,	39,	172,	0,	0,	0,	0,	0,	0,	0,	89,	0,	383,	0,	0,	377,	0,	0,	124,	0,	280,	76,	0,	0,	0,	0,	218},
        		{148,	384,	0,	349,	0,	278,	119,	356,	0,	197,	0,	0,	413,	235,	323,	289,	0,	215,	144,	0,	0,	0,	173,	337,	0,	302,	0,	0,	0,	300,	343,	0,	0},
        		{168,	0,	0,	221,	0,	175,	317,	305,	0,	397,	0,	0,	0,	0,	0,	101,	0,	406,	66,	377,	0,	0,	350,	116,	0,	319,	0,	0,	0,	127,	0,	0,	0},
        		{172,	213,	0,	556,	0,	0,	218,	293,	367,	89,	0,	0,	352,	114,	495,	0,	0,	70,	316,	0,	173,	350,	0,	0,	0,	0,	0,	0,	180,	0,	282,	0,	0},
        		{306,	0,	0,	206,	0,	0,	0,	0,	233,	0,	0,	205,	0,	0,	0,	70,	433,	0,	196,	0,	337,	116,	0,	0,	0,	0,	128,	0,	0,	162,	0,	0,	0},
        		{0,	0,	0,	0,	198,	235,	0,	136,	0,	0,	0,	0,	0,	145,	0,	0,	246,	0,	0,	124,	0,	0,	0,	0,	0,	66,	0,	132,	106,	0,	0,	108,	0},
        		{175,	230,	0,	548,	0,	176,	0,	114,	235,	0,	268,	0,	671,	101,	0,	0,	0,	0,	354,	0,	302,	319,	0,	0,	66,	0,	0,	165,	128,	334,	0,	162,	0},
        		{263,	0,	156,	400,	0,	0,	0,	264,	111,	0,	0,	105,	0,	0,	0,	199,	306,	0,	255,	280,	0,	0,	0,	128,	0,	0,	0,	0,	0,	61,	0,	0,	162},
        		{0,	0,	0,	0,	0,	0,	0,	108,	246,	0,	303,	0,	0,	0,	0,	0,	83,	0,	0,	76,	0,	0,	0,	0,	132,	165,	0,	0,	0,	0,	0,	0,	0},
        		{0,	97,	0,	0,	126,	0,	392,	0,	0,	0,	0,	0,	587,	59,	0,	567,	0,	204,	0,	0,	0,	0,	180,	0,	106,	128,	0,	0,	0,	0,	480,	116,	0},
        		{204,	509,	255,	341,	0,	91,	0,	239,	102,	0,	0,	0,	0,	0,	0,	169,	0,	0,	196,	0,	300,	127,	0,	162,	0,	334,	61,	0,	0,	0,	0,	0,	0},
        		{419,	393,	0,	660,	0,	622,	2332,	0,	624,	200,	632,	0,	69,	0,	511,	0,	0,	283,	490,	0,	343,	0,	282,	0,	0,	0,	0,	0,	480,	0,	0,	0,	0},
        		{0,	150,	0,	0,	111,	338,	0,	0,	0,	0,	107,	0,	0,	172,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	108,	162,	0,	0,	116,	0,	0,	0,	0},
        		{0,	0,	80,	0,	0,	0,	0,	213,	108,	0,	0,	144,	0,	0,	0,	0,	190,	0,	0,	218,	0,	0,	0,	0,	0,	0,	162,	0,	0,	0,	0,	0,	0}};
        dijkstraForPath1 ds = new dijkstraForPath1();
        int numVia=0;
        ds.dijkstra(adjacencyMatrix, start, dest, district_Raj);
        System.out.println();
        numVia = ds.numberOfVehicle(arr, weight);
        
        if(numVia >= 10000) {
        	int cd = 15000 - numVia;
		    System.out.println("Do you want to add Via Path (Y/N): ");
		    ch1 = scan.next().charAt(0);
		    if(ch1 == 'Y' || ch1 == 'y') {
		    	System.out.println("Enter the Weight:");
		    	int wght = scan.nextInt();
		    	System.out.println("Enter your Via Destination:");
		    	String destVia = scan.next();
	    		
		    	if(wght <= cd) {
		    		for(int i=0;i<district_Raj.length;i++) {
				      	if(district_Raj[i].equals(destVia)) dest = i;}
		    		ds.dijkstra(adjacencyMatrix, start, dest, district_Raj);
		    		System.out.println("Weight for via path is less than the empty space in the vehicle, So we can allot.");
		    		System.out.println("\nYou need to add your weight in the last Vehicle of Capacity (Kg) : 15000");
		    		System.out.println("\n\nDrop "+wght+" weight at "+destVia+ " and Reach to the Final Destination.");
		    	}
		    	else {
		    		System.out.println("Weight for via path is greater than the empty space in the vehicle, So send another vehichle to that destination.");
		    	}
		    }
	    }
    	else {
    		System.out.println("We can't add weight to via path.");
    	}
	    
	    System.out.print("\n\nDo you want to Continue (Y/N)");
        ch = scan.next().charAt(0);
        }while(ch == 'Y' || ch == 'y');
	    System.out.print("Exit");

    }
}
