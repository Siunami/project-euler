(ns euler.p001)

; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;
; Find the sum of all the multiples of 3 or 5 below 1000.

;; for each number below 1000, get a collection that is a multiple of 3 or 5
;; then reduce applying the sum function.

(defn solution [] (reduce +
                          (filter
                           (fn [num] (or (= (mod num 5) 0)
                                         (= 0 (mod num 3))))
                           (range 1000))))
