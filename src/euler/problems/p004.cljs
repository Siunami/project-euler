(ns euler.p004)


; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
;
; Find the largest palindrome made from the product of two 3-digit numbers.

;; 		 1  2  3  4  5  6  7  8  9  (A)
;;	1  1  2  3  4  5  6  7  8  9
;;  2  2  4  6  8  10 12 14 16 18
;;  3  3  6  9  12 15 18 21 24 27
;;  4  4  8  12 16 20 24 28 32 36
;;  5  5  10 15 20 25 30 35 40 45
;;  6  6  12 18 24 30 36 42 48 54
;;  7  7  14 21 28 35 42 49 56 63
;;  8  8  16 24 32 40 48 56 64 72
;;  9  9  18 27 36 45 54 63 72 81
;; (B)

;; sub-GOAL: Need to get the right order to decrement
;; Solution: need to go in diagonals. Order: 81 (9,9)*, 72 (8,9)*, 64 (8,8)*, 63 (7,9), 56 (7,8)*,54 (6,9),49 (7,7)*
;; start with a=9 b=9 a x b and check palindrome
;; if b=9 or a=1, then if a == b start diagonal function at (a, b-1) else

(defn palindrome? [num]
  (= (str num) (apply str (reverse (str num)))))

(defn get-next-diagonal [a b]
  (if (= a b) [(- a 1) b] [a (- b 1)]))

(defn parse-int [s]
  (Integer. (re-find #"[0-9]*" s)))

;; if num = 9, 99, 999 etc. , return true.
;; else return false
(defn only-nines [num]
   (= 0 (reduce +
                (map (fn [char] (if (= char "9") 0 1))
                     (clojure.string/split (str num) #"")))))


;; startA, startB mark the coordinates of the current diagonal being searched
;; currA, currB is the coordinate on that diagonal being searched.
(defn largest-palindrome-helper [startA startB currA currB]
  ;; calculate next diagonal starting position
  (let [[nextA nextB] (get-next-diagonal startA startB)]
    ;; if current coordinates is a palindrome, return product of coordinates
      (if (palindrome? (* currA currB))
        (* currA currB)
        ;; else, if end of a diagonal , recurse starting at coords next diagonal.
        ;; otherwise, recurse starting at next coordinate on the current diagonal.
        (cond
          (or (= currA 1) (only-nines currB)) (largest-palindrome-helper nextA nextB nextA nextB)
          :else (largest-palindrome-helper startA startB (- currA 1) (+ currB 1))))))

;; num is number of digits
(defn largest-palindrome [num]
  ;; start with the highest number for a and b given digit limit
  ;;  which is max number of 9s for both a and b
  (let [a (parse-int (apply str (map (fn [num] 9) (range num))))
        b a]
    (largest-palindrome-helper a b a b)))

;; TESTING

(largest-palindrome 1)
;; Ans 9

(largest-palindrome 2)
;; Ans 9009

(largest-palindrome 3)
;; Ans 906609
