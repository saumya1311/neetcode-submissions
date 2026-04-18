class TrieNode{
    HashMap<Character,TrieNode> children=new HashMap<Character,TrieNode>();
    String word=null;
    public TrieNode(){}
}

class Solution {
    char[][] fullboard;
    ArrayList<String> answer=new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        for(String word: words){
            TrieNode node=root;
            for(Character letter:word.toCharArray()){
                if(!node.children.containsKey(letter)){
                    node.children.put(letter,new TrieNode());
                }

                node = node.children.get(letter);
            }
            node.word=word;
        }
        this.fullboard=board;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(root.children.containsKey(board[i][j])){
                    bt(i,j,root);
                }
            }
        }
        return answer;
    }

    public void bt(int i,int j, TrieNode parent){
        char letter=fullboard[i][j];
        TrieNode curr= parent.children.get(letter);

        if(curr.word != null){
            answer.add(curr.word);
            curr.word = null;
        }
        fullboard[i][j]='#'; //alr visited marked

        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};

        for(int d=0;d<4;d++){
            int nR=i+rowoffset[d];
            int nC=j+coloffset[d];

            if(nR<0 || nC<0 || nR>=fullboard.length || nC>=fullboard[0].length) continue;

            if(curr.children.containsKey(fullboard[nR][nC])){
                bt(nR,nC, curr);
            }
        }
        fullboard[i][j]=letter; //back to og postion

        if(curr.children.isEmpty()){
            parent.children.remove(letter);
        }
    }
}
