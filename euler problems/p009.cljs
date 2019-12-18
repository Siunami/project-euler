; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;
; a^2 + b^2 = c^2
; For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;
; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.

;; 2 equations

;; a + b + c = 1000
;; a^2 + b^2 = c^2

;; can find triplets and check if the triplet pair (reduce + [TRIPLET PAIR]) to 1000

; Euclid's formula[3] is a fundamental formula for generating Pythagorean triples given an arbitrary pair of integers m and n with m > n > 0. The formula states that the integers
;
; a=m^{2}-n^{2},b=2mn ,c=m^{2}+n^{2}

(defn sum-to? [numbers val] (= val (reduce + numbers)))
