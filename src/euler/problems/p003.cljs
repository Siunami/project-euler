(ns euler.p003)

; The prime factors of 13195 are 5, 7, 13 and 29.
;
; What is the largest prime factor of the number 600851475143 ?


; Fermat's Little Theorem:
; If n is a prime number, then for every a, 1 < a < n-1,
;
; a^(n-1) ≡ 1 (mod n)
; OR
; a^(n-1) % n = 1

; (defn get-factors [num]
;   (let [factors ()]
;     (for [n (/ num 2)]
;       (if (mod num n)
;         (conj factors n)))))

; (defn exp [x n]
;   (reduce * (repeat n x)))
;
; (defn prime? [num]
;   (map (fn [a] (do
;                  (println a)
;                  (= 1 (exp a
;                          (- num 1)))))
;        (range 2 (- num 1))))
