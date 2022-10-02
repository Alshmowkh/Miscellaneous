/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

public class CFG {

//    Tree parse(int goal, int start, int end) {
//        double bestScore = iScore[start][end][goal];
//        double normBestScore = op.testOptions.lengthNormalization ? (bestScore / wordsInSpan[start][end][goal]) : bestScore;
//        String goalStr = stateIndex.get(goal);
//     
//        BinaryRule br = null;
//        if (end - start <= 1 && tagIndex.contains(goalStr)) {
//
//            IntTaggedWord tagging = new IntTaggedWord(words[start], tagIndex.indexOf(goalStr));
//            String contextStr = getCoreLabel(start).originalText();
//            float tagScore = lex.score(tagging, start, wordIndex.get(words[start]), contextStr);
//
//            if (tagScore > Float.NEGATIVE_INFINITY || floodTags) {
//                CoreLabel terminalLabel = getCoreLabel(start);
//                Tree wordNode = tf.newLeaf(terminalLabel);
//                Tree tagNode = tf.newTreeNode(goalStr, Collections.singletonList(wordNode));
//                tagNode.setScore(bestScore);
//                if (terminalLabel.tag() != null) {
//                    tagNode.label().setValue(terminalLabel.tag());
//                }
//                if (tagNode.label() instanceof HasTag) {
//                    ((HasTag) tagNode.label()).setTag(tagNode.label().value());
//                }
//                return tagNode;
//            }
//
//        }
//
//        for (int i = start + 1; i < end; i++) {
//            for (Iterator<BinaryRule> binaryI = bg.ruleIteratorByParent(goal); binaryI.hasNext();) {
//                br = binaryI.next();
//                double score = br.score + iScore[start][i][br.leftChild] + iScore[i][end][br.rightChild];
//                boolean matches;
//                matches = matches(score, bestScore);
//                if (matches) {
//                    Tree leftChildTree = parse(br.leftChild, start, i);
//                    Tree rightChildTree = parse(br.rightChild, i, end);
//                    List<Tree> children = new ArrayList<>();
//                    children.add(leftChildTree);
//                    children.add(rightChildTree);
//                    Tree result = tf.newTreeNode(goalStr, children);
//                    result.setScore(score);
//                    return result;
//                }
//            }
//        }
//
//        return null;
//    }
//
//    Object parsey(String goal) {
//        Object obj = null;
//        
//        return obj;
//    }

    void ini() {
//        Object parse = parsey("S");
    }

    public static void main(String[] args) {
        CFG cfg = new CFG();
        cfg.ini();
    }

}
