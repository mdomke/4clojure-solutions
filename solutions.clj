; Nothing but the truth
; https://www.4clojure.com/problem/1
true


; Simple Math
; https://www.4clojure.com/problem/2
4


; Intro to Strings
; https://www.4clojure.com/problem/3
"HELLO WORLD"


; Intro to Lists
; https://www.4clojure.com/problem/4
:a :b :c


; Lists: conj
; https://www.4clojure.com/problem/5
'(1 2 3 4)


; Intro to Vectors
; https://www.4clojure.com/problem/6
:a :b :c


; Vectors: conj
; https://www.4clojure.com/problem/7
[1 2 3 4]


; Intro to Sets
; https://www.4clojure.com/problem/8
#{:a :b :c :d}


; Sets: conj
; https://www.4clojure.com/problem/9
2


; Intro to Maps
; https://www.4clojure.com/problem/10
20


; Maps: conj
; https://www.4clojure.com/problem/11
[:b 2]


; Intro to Sequences
; https://www.4clojure.com/problem/12
3


; Sequences: rest
; https://www.4clojure.com/problem/13
[20 30 40]


; Intro to Functions
; https://www.4clojure.com/problem/14
8


; Double Down
; https://www.4clojure.com/problem/15
#(* % 2)


; Hello World
; https://www.4clojure.com/problem/16
#(str "Hello, " % "!")


; Sequnences: map
; https://www.4clojure.com/problem/17
[6 7 8]


; Sequnences: filter
; https://www.4clojure.com/problem/18
[6 7]


; Last Element
; https://www.4clojure.com/problem/19
(comp peek vec)


; Penultimate Element
; https://www.4clojure.com/problem/20
(comp peek pop vec)


; Nth Element
; https://www.4clojure.com/problem/21
#(first (drop %2 %))


; Count a Sequence
; https://www.4clojure.com/problem/22
#(reduce (fn [x y] (inc x)) 0 %)


; Reverse a Sequence
; https://www.4clojure.com/problem/23
#(reduce (fn [x y] (conj x y)) '() %)


; Sum it all up
; https://www.4clojure.com/problem/24
#(reduce + %)


; Find the odd numbers
; https://www.4clojure.com/problem/25
#(filter odd? %)


; Fibonacci Sequence - lazy sequence
; https://www.4clojure.com/problem/26
(fn [n]
  (take n ((fn fib [a b]
            (cons a (lazy-seq (fib b (+ a b)))))
            1 1)))


; Fibonacci Sequence - map
; https://www.4clojure.com/problem/26
(fn [n]
  (letfn [(fib [x]
            (if (>= 2 x)
              1
              (+ (fib (dec x)) (fib (- x 2)))))]
    (map fib (range 1 (inc n)))))


; Palindrome detector
; https://www.4clojure.com/problem/27
#(= (vec %) (rseq (vec %)))


; Flatten a Sequence
; https://www.4clojure.com/problem/28
(fn [coll]
  (reduce
    (fn flatr [v e]
      (if (coll? e)
        (reduce flatr v e)
        (conj v e)))
      [] coll))


; Get the Caps
; https://www.4clojure.com/problem/29
#(apply str (re-seq #"[A-Z]" %))


; Compress a Sequence
; https://www.4clojure.com/problem/30
#(map first (partition-by identity %))


; Pack a Sequence
; https://www.4clojure.com/problem/31
#(partition-by identity %)


; Duplicate a Sequence
; https://www.4clojure.com/problem/32
(fn [coll] (mapcat #(vector % %) coll))


; Replicate a Sequence
; https://www.4clojure.com/problem/33
(fn [coll times] (mapcat (fn [e] (repeat times e)) coll))


; Implement range
; https://www.4clojure.com/problem/34
(fn [start end] (take (- end start) (iterate inc start)))


; Local bindings
; https://www.4clojure.com/problem/35
7


; Let it Be
; https://www.4clojure.com/problem/36
[x 7, y 3, z 1]


; Regular Expressions
; https://www.4clojure.com/problem/37
"ABC"


; Maximum value
; https://www.4clojure.com/problem/38
(fn [& more] (reduce (fn [x y] (if (>= x y) x y)) more))


; Interleave two Seqs
; https://www.4clojure.com/problem/39
(fn [first second] (mapcat (fn [& more] more) first second))


; Interpose a Seq
; https://www.4clojure.com/problem/40
(fn [sep coll] (rest (mapcat #(vector sep %) coll)))


; Drop Every Nth Item
; https://www.4clojure.com/problem/41
(fn [coll n] (apply concat (partition-all (dec n) n coll)))


; Factorial Fun
; https://www.4clojure.com/problem/42
(fn [n] (reduce * (range 1 (inc n))))


; Reverse Interleave
; https://www.4clojure.com/problem/43
(fn [coll len]
  (let [parts (map-indexed (fn [i e] (vector (mod i len) e)) coll)]
    (vals (reduce
            (fn [result elems]
              (let [k (first elems) v (last elems)]
                (assoc result k (conj (get result k []) v))))
            (sorted-map) parts))))


; Rotate Sequence
; https://www.4clojure.com/problem/44
(fn [dir coll]
  (let [n (mod dir (count coll))]
    (concat (drop n coll) (take n coll))))


; Intro to Iterate
; https://www.4clojure.com/problem/45
'(1 4 7 10 13)'


; Flipping Out
; https://www.4clojure.com/problem/46
(fn [func] (fn [a b] (func b a)))
