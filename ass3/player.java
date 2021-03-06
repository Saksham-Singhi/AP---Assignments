import java.util.Scanner;

class player {
    private String name;
    private int flr;
    private int pts;

    public player(String name) {
        this.name = name;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hit enter to roll the dice");
        sc.nextLine();
        dice dice = new dice();
        dice.roll();
        int n = dice.getfase();
        System.out.println("dice gave " + n);

        if (n == 1) {
            flr = 0;
            pts = 1;
            System.out.println("Player flr floor: " + flr+ "\r\n" + name + " has reached an Empty Floor \r\n" + "Total points: " + pts);
            nextMove();
        } else if (n == 2) {
            System.out.println("Game cannot start until you get 1");
            run();
        }
    }
    
    public int getroll() {
	    dice dice = new dice();
	    dice.roll();
	    int n = dice.getfase();
	    return n;
    }

    public void nextMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hit enter to roll the dice");
        sc.nextLine();
        int n = getroll();
        System.out.println("dice gave " + n);
        if (flr + n <= 13) {
        flr = flr + n;
        Move();}
        else {
        	System.out.print("Out of Bounds, Roll Again");
        	nextMove();
        }
    }

    public void Move() {
        String newflr = typ(flr);

        if (newflr.equals("e")) {
            elevator Elev = new elevator();
            System.out.println("Player position Floor- " + flr+ "\r\n" + name + " has reached a elevator floor");
            Elev.setpts(pts);
            pts = Elev.addpts();
            System.out.println("total points: " + pts);
            Elev.setpos(flr);
            flr = Elev.addpos();
            Move();
        } else if (newflr.equals("l")) {
            ladder lad = new ladder();
            System.out.println("player position Floor- " + flr+ "\r\n" + name + " has reached a ladder floor");
            lad.setpts(pts);
            pts = lad.addpts();
            System.out.println("total points: " + pts);
            lad.setpos(flr);
            flr = lad.addpts();
            Move();
        } else if (newflr.equals("s")) {
            snake sna = new snake();
            System.out.println("Player position FLoor- " + flr+ "\r\n" + name + " has reached a snake floor");
            sna.setpts(pts);
            pts = sna.addpts();
            System.out.println("total points: " + pts);
            sna.setpos(flr);
            flr = sna.addpos();
            Move();
        } else if (newflr.equals("c")) {
            kingCobra cob = new kingCobra();
            System.out.println("Player position FLoor- " + flr + "\r\n" + name + " has reached a cobra floor");
            cob.setpts(pts);
            pts = cob.addpts();
            System.out.println("total points: " + pts);
            cob.setpos(flr);
            flr = cob.addpos();
            Move();
        } else if (newflr.equals("mt")) {
            System.out.println("player position Floor- " + flr+ "\r\n" + name + " has reached an Empty floor");
            pts = pts + 1;
            System.out.println("Total points: " + pts);
            nextMove();
        } else if (newflr.equals("f")) {
            System.out.println("player position Floor- " + flr+ "\r\n" + name + " has reached The Final Floor"+ "\r\n" + "Total points: " + pts+ "\r\n" + "Game over" + "\r\n" + name + " accumulated " + pts + " points.");
        }
    }

    public String typ(int cs) {
	            if (cs==2) {
	                return ("e");
	            }
	            else if (cs == 5) {
	                return ("s");
	            }
	            else if (cs == 8)  {
	                return ("l");
	            }
	            else if (cs == 11)  {
	                return ("c");
	            }
	            else if (cs == 13)  {
	                return ("f");
	            }
	            else  {
	                return ("mt");
	            }
	        }
        
    
}

