package B6123338_B6122997_B6121921;

public class BoxFac {
    public Box createBox(int id,String size,int weight,String transport){
        String detail="Size of Box: ";
        int mini[]={14,20,6};
        int s[]={20,30,11};
        int m[]={27,43,20};
        int l[]={35,45,25};
        int xl[]={40,50,30};
        int i=0;
        switch(size.toLowerCase()){
            case "mini":for(i=0;i< mini.length;i++){
                if(i!= mini.length-1){
                    detail+=mini[i]+"x";
                }else{
                    detail+=mini[i]+" inches";
                }
            }break;
            case "s":for(i=0;i< s.length;i++){
                if(i!= s.length-1){
                    detail+=s[i]+"x";
                }else{
                    detail+=s[i]+" inches";
                }
            }break;
            case "m":for(i=0;i< m.length;i++){
                if(i!= m.length-1){
                    detail+=m[i]+"x";
                }else{
                    detail+=m[i]+" inches";
                }
            }break;
            case "l":for(i=0;i< l.length;i++){
                if(i!= l.length-1){
                    detail+=l[i]+"x";
                }else{
                    detail+=l[i]+" inches";
                }
            }break;
            case "xl":for(i=0;i< xl.length;i++){
                if(i!= xl.length-1){
                    detail+=xl[i]+"x";
                }else{
                    detail+=xl[i]+" inches";
                }
            }break;
        default:break;
        }
        return new Box(id,size,weight,detail,transport);
    }
}
