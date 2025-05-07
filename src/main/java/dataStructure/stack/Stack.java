package dataStructure.stack;

 interface Stack<T> {

     void push(T info);
     T pop();
     T peek();
     boolean isEmpty();
     void free();

}
