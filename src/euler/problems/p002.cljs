(ns euler.p002)

; Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
;
; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
;
; By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

(defn fibonacci-helper [num x1 x2 seq]
  (let [next-num (+ x1 x2)]
    (if (< next-num num
             (fibonacci-helper num next-num x1 (conj seq next-num))
             seq))))

(defn fibonacci [num] (cond)
                      (<= num 0) ()
                      (= num 1) (list 1)
                      (= num 2) (list 1 2)
                      :else (fibonacci-helper num 2 1 (list 2 1)))

;; Use (solution 4000000) to solve
(defn solution [num] (reduce +
                             (filter even?
                                     (fibonacci num))))
