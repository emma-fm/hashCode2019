public class Foto {
    int ID ;

    char pos;
    String[] tags;
    public Foto(String inTag, int inID){
        pos = inTag.charAt(0);
        ID = inID;
        int asciiChar = (int) inTag.charAt(2);
        boolean paramos = true;
        int ultimaPos = 0;
        for( int i = 3; i<inTag.length()  &&  paramos;i++){
            if(asciiChar == 32 ){
                paramos = false;
                ultimaPos = i;
            }
        }
        String aux = inTag.substring(ultimaPos);
        String[] parts = aux.split(" ");
        tags = new String[parts.length - 2];
        for(int i = 0; i< tags.length;i++){
            tags[i] = parts[i + 2];
        }

    }
    public int getID(){
        return this.ID;
    }
    public char getPos() {
        return pos;

    }
    public String[] getTags(){
        return this.tags;
    }


}
