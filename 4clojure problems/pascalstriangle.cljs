; Pascal's triangle is a triangle of numbers computed using the following rules:
;
; - The first row is 1.
; - Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.
;
; Write a function which returns the nth row of Pascal's Triangle.
;
; (= (__ 1) [1])
;
; (= (map __ (range 1 6))
;    [     [1]
;         [1 1]
;        [1 2 1]
;       [1 3 3 1]
;      [1 4 6 4 1]])
;
; (= (__ 11)
;    [1 10 45 120 210 252 210 120 45 10 1])

;; https://en.wikipedia.org/wiki/Pascal%27s_triangle
;; Contains an algorithm for computing a row by itself.


;; Helper function for formula
(defn get-fraction [n k]
  (if (= k 0)
    1
    (/ (- (+ n 1) k) k)))

;; Formula to calculate element k in row n.
;; requires value of prevElement (k - 1)
(defn calculate-element [prevElement n k]
  (* prevElement (get-fraction n k)))

;; If end of row, then return values
;; else, calculate next value by incrementing k and add calculated element to [elements]
(defn calculate-row-helper [n k prevElement elements]
  (let [nextElement (calculate-element prevElement n k)]
    (if (> (count elements) n)
      elements
      (calculate-row-helper n (inc k) nextElement (conj elements nextElement)))))

(defn calculate-row [row]
  (calculate-row-helper row 0 1 []))
