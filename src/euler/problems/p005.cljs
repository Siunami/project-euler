
; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;
; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

; means that 1 to 10 are all factors of 2520

; base case
; 1 to 1 -> 1
; 1 to 2 -> 2
; 1 to 3 -> 6
; 1 to 4 -> 12
; 1 to 5 ->

;; you can treat each number as a period.
;; you're looking for the first time th periods are in sync besides at 0.

;; you can multiply the largest number (x) by an increasing (i)
;; each time, check if all numbers (0 to x) divide cleanly into the product of (x * i)
;; if they don't then increment i and try again.

;; return 0 if true 1 if not true
(defn check-divisible? [num divisor] (if (= 0 (mod num divisor)) 0 1))

(defn smallest-multiple? [numbers num i]
  (let [possible-answer (* num i)]
    ;; if collection reduces to 0, then all numbers are divisible
    (= 0 (reduce +
                 ;; collection of 1s and 0s
                 (map (fn [n] (check-divisible? possible-answer n))
                      numbers)))))

(defn solution [num]
  ;; numbers is all numbers we need to check
  (let [numbers (vec (range 1 (inc num)))]
    (loop [i 1]
      ;; if smallest-multiple is found, return the num * i
      ;; else increment i and try again
      (if (smallest-multiple? numbers num i)
          (* num i)
          (recur (inc i))))))

;; TESTING

(solution 5)
;; 60

(solution 6)
;; 60

(solution 7)
;; 420

(solution 10)
;; 2520

(solution 20)
;; 232792560
