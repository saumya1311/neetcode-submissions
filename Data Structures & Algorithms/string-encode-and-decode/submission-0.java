class Solution {

    public String encode(List<String> strs) {
        if(strs.size()==0){
            return Character.toString((char)258);
        }

        String sep=Character.toString((char)257);
        StringBuilder sb=new StringBuilder();
        for (String s:strs){
            sb.append(s);
            sb.append(sep);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }

    public List<String> decode(String str) {
        if(str.equals(Character.toString((char)258))){
            return new ArrayList();
        }

        String sep=Character.toString((char)257);
        return Arrays.asList(str.split(sep,-1));
    }
}
