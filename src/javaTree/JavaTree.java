package javaTree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

public class JavaTree extends JFrame {

    JFrame frame;
    DefaultMutableTreeNode root;
    JTree tree;
    JScrollPane scroll;

    public JavaTree() {
        frame = new JFrame("SUMO Ontology");
        frame.setSize(500, 400);
        frame.setLayout(new GridLayout(3, 1));
        frame.setLocationRelativeTo(null);

        root = new DefaultMutableTreeNode("Yemen");
        tree = new JTree(root);
        scroll = new JScrollPane(tree);
//        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel lbl = new JLabel("yemen", JLabel.CENTER);
        JButton btn = new JButton("Click me!");
        btn.setSize(20, 20);
//        panel.add(scroll);
//        frame.add(panel, BorderLayout.SOUTH);
//        scroll.setBounds(5, 5, 30, 60);
         scroll.setPreferredSize(new Dimension(420, 190));
        frame.add(scroll, BorderLayout.CENTER);
//        frame.add(lbl);
//        frame.add(btn);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        JavaTree cls = new JavaTree();
//new JavaTree().setVisible(true);
//        System.out.println(cls.top.getUserObject());
    }
}
