package com.example.tnp_ds;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class first extends Fragment {
    private TextView text;
    public String ans;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (savedInstanceState == null) {
            View view = inflater.inflate(R.layout.fragment_first, container, false);

            text = view.findViewById(R.id.text2);
            //text.setMovementMethod(new ScrollingMovementMethod());
            Bundle bundle = getArguments();
            final String Ques = bundle.getString(Constants.QUESTION_QUES, "");
            switch (Ques)
            {
                case "1.What is data structures?":
                    ans="Data Structure is a particular way of organising data in a computer so that it can be used effectively.";
                    break;
                case "2.What are the types of data structures?":
                    ans="Linear Data Structure.\nNon Linear Data Structure.";
                    break;
                case "3.What is linear data structure?":
                    ans="A data structure is called linear if all of its elements are arranged in the sequential order. In linear data structures, the elements are stored in a non-hierarchical way where each item has the successors and predecessors except the first and last element.";
                    break;
                case "4.What is non linear data structure?":
                    ans="The Non-linear data structure does not form a sequence i.e. each item or element is connected with two or more other items in a non-linear arrangement. The data elements are not arranged in the sequential structure.";
                    break;
                case "5.What is a stack?":
                    ans="Stack is a linear data structure which the order LIFO(Last In First Out) or FILO(First In Last Out) for accessing elements.";
                    break;
                case"6.Which data structures are used for BFS and DFS of a graph?":
                    ans="Queue is used for BFS \nStack is used for DFS. DFS can also be implemented using recursion (Note that recursion also uses function call stack).";
                    break;
                case"7.Can doubly linked be implemented using a single pointer variable in every node?":
                    ans="Doubly linked list can be implemented using a single pointer. See XOR Linked List – A Memory Efficient Doubly Linked List";
                    break;
                case "8.Explain Binary Search Tree":
                    ans="A binary search tree stores data in such a way that they can be retrieved very efficiently. The left subtree contains nodes whose keys are less than the node’s key value, while the right subtree contains nodes whose keys are greater than or equal to the node’s key value. Moreover, both subtrees are also binary search trees.";
                    break;
                case"9.What are multidimensional arrays?":
                    ans="Multidimensional arrays make use of multiple indexes to store data. It is useful when storing data that cannot be represented using single dimensional indexing, such as data representation in a board game, tables with data stored in more than one column.";
                    break;
                case"10.Are linked lists considered linear or non-linear data structures?":
                    ans="It depends on where you intend to apply linked lists. If you based it on storage, a linked list is considered non-linear. On the other hand, if you based it on access strategies, then a linked list is considered linear.";
                    break;
                case"11.How does dynamic memory allocation help in managing data?":
                    ans="Apart from being able to store simple structured data types, dynamic memory allocation can combine separately allocated structured blocks to form composite structures that expand and contract as needed.";
                    break;
                case"12.What is FIFO?":
                    ans="FIFO stands for First-in, First-out, and is used to represent how data is accessed in a queue. Data has been inserted into the queue list the longest is the one that is removed first.";
                    break;
                case"13.What is an ordered list?":
                    ans="An ordered list is a list in which each node’s position in the list is determined by the value of its key component, so that the key values form an increasing sequence, as the list is traversed.";
                    break;
                case"14.What is merge sort?":
                    ans="Merge sort, is a  divide-and-conquer approach for sorting the data. In a sequence of data, adjacent ones are merged and sorted to create bigger sorted lists. These sorted lists are then merged again to form an even bigger sorted list, which continues until you have one single sorted list.";
                    break;
                case"15.Differentiate NULL and VOID":
                    ans=" Null is a value, whereas Void is a data type identifier. A variable that is given a Null value indicates an empty value. The void is used to identify pointers as having no initial size.";
                    break;
                case"16.What is the difference between a PUSH and a POP?":
                    ans="Pushing and popping applies to the way data is stored and retrieved in a stack. A push denotes data being added to it, meaning data is being “pushed” into the stack. On the other hand, a pop denotes data retrieval, and in particular, refers to the topmost data being accessed.";
                    break;
                case"17.Do all declaration statements result in a fixed reservation in memory?":
                    ans="Most declarations do, with the exemption of pointers. Pointer declaration does not allocate memory for data, but for the address of the pointer variable. Actual memory allocation for the data comes during run-time.";
                    break;
                case"18.What is a linear search?":
                    ans="A linear search refers to the way a target key is being searched in a sequential data structure. In this method, each element in the list is checked and compared against the target key. The process is repeated until found or if the end of the file has been reached.";
                    break;
                case"19.What is a postfix expression?":
                    ans="A postfix expression is an expression in which each operator follows its operands. The advantage of this form is that there is no need to group sub-expressions in parentheses or to consider operator precedence.";
                    break;
                case"20.What is Data abstraction?":
                    ans="Data abstraction is a powerful tool for breaking down complex data problems into manageable chunks. This is applied by initially specifying the data objects involved and the operations to be performed on these data objects without being overly concerned with how the data objects will be represented and stored in memory.";
                    break;
                case"21.How do you insert a new item in a binary search tree?":
                    ans="Assuming that the data to be inserted is a unique value (that is, not an existing entry in the tree), check first if the tree is empty. If it’s empty, just insert the new item in the root node. If it’s not empty, refer to the new item’s key. If it’s smaller than the root’s key, insert it into the root’s left subtree, otherwise, insert it into the root’s right subtree.";
                    break;
                case"22.How do signed and unsigned numbers affect memory?":
                    ans="In the case of signed numbers, the first bit is used to indicate whether positive or negative, which leaves you with one bit short. With unsigned numbers, you have all bits available for that number. The effect is best seen in the number range (an unsigned 8-bit number has a range 0-255, while the 8-bit signed number has a range -128 to +127.";
                    break;

            }
            text.setText(ans);
            String s = (String) text.getText();
            MyInterface myInterface = (MyInterface) getActivity();
            myInterface.copy(s);
            return  view;
        }
        return null;
    }

}
