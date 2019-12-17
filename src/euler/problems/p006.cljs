; The sum of the squares of the first ten natural numbers is,
;
; 1^2 + 2^2 + ... + 10^2 = 385
; The square of the sum of the first ten natural numbers is,
;
; (1 + 2 + ... + 10)^2 = 55^2 = 3025
; Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
;
; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

(defn sum-of-squares [numbers]
  (reduce + (map (fn [n] (* n n)) numbers)))

(defn square-of-sums [numbers]
  (let [sum (reduce + numbers)]
    (* sum sum)))


(defn solution [num]
  (let [numbers (vec (range 1 (inc num)))]
    (- (square-of-sums numbers) (sum-of-squares numbers))))

;; TESTING

(solution 10)
;; 2640

(solution 100)
;; 25164150
