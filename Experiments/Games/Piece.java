

public class Piece
    {
        public String name;
        public boolean white;

        public Piece(String n, boolean w)
        {
            this.name = n;
            this.white = w;
        }

        public Piece()
        {
            this.name = " ";
            this.white = true;
        }
    }