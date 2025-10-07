class pair {
    String name ;
    int step;
    public pair(String name,int step){
        this.name = name;
        this.step = step;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            pair p = q.poll();
            String names = p.name;
            int steps = p.step;
            if(names.equals(endWord) == true) return steps;
            for(int i=0;i<names.length();i++){
                char replace[] = names.toCharArray();
                for(char ch='a';ch <= 'z';ch++){
                    replace[i] = ch;
                    String wd = new String(replace);

                    if(set.contains(wd) == true){
                        set.remove(wd);
                        q.add(new pair(wd,steps+1));
                    }
                }
            } 
        }
        return 0;
    }
}