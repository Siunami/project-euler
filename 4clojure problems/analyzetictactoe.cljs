; A tic-tac-toe board is represented by a two dimensional vector.
; X is represented by :x, O is represented by :o, and empty is represented by :e.
; A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row.
; Write a function which analyzes a tic-tac-toe board
; returns :x if X has won, :o if O has won, and nil if neither player has won.
;
; (= nil (__ [[:e :e :e]
;             [:e :e :e]
;             [:e :e :e]]))
;
; (= :x (__ [[:x :e :o]
;            [:x :e :e]
;            [:x :e :o]]))
;
; (= :o (__ [[:e :x :e]
;            [:o :o :o]
;            [:x :e :x]]))
;
; (= nil (__ [[:x :e :o]
;             [:x :x :e]
;             [:o :x :o]]))
;
; (= :x (__ [[:x :e :e]
;            [:o :x :e]
;            [:o :e :x]]))
;
; (= :o (__ [[:x :e :o]
;            [:x :o :e]
;            [:o :e :x]]))
;
; (= nil (__ [[:x :o :x]
;             [:x :o :x]
;             [:o :x :o]]))

;; For a sequence of 3 nums, will check if a win for :x or :o
;; otherwise, return nil
(defn check-win [nums]
  (let [count (frequencies nums)]
    (cond
      (= 3 (get count :x)) :x
      (= 3 (get count :o)) :o
      :else nil)))

(defn check-horizontal [row]
  (check-win row))

;; Gets the three vertical columns and checks for win.
;; returns a collection of values returned from (check-win)
(defn check-verticals [board]
  (let [row1 (get board 0)
        row2 (get board 1)
        row3 (get board 2)]
    (for [i (range 0 3)]
        (check-win [(get row1 i) (get row2 i) (get row3 i)]))))

;; Gets the two diagonal columns and checks for win.
;; returns a collection of values returned from (check-win)
(defn check-diagonals [board]
  (let [row1 (get board 0)
        row2 (get board 1)
        row3 (get board 2)]
    (list
      (check-win [(get row1 0) (get row2 1) (get row3 2)])
      (check-win [(get row1 2) (get row2 1) (get row3 0)]))))

;; reduces all collections into a single collection.
;; all nil results filtered
;; if (first) contains a value still, will either be :x or :y for any valid board
(defn analyze-board [board]
  (first (filter (fn [val] (not (nil? val)))
           (reduce into [(check-diagonals board)
                         (check-verticals board)
                         (map check-horizontal board)]))))



(analyze-board [[:e :x :e]
                [:o :o :o]
                [:x :e :x]])
;; :o

(analyze-board [[:x :o :x]
                [:x :o :o]
                [:x :x :o]])
;; :x

(analyze-board [[:e :e :e]
                [:x :o :o]
                [:x :x :o]])
;; nil

(analyze-board [[:e :e :x]
                [:o :x :o]
                [:x :x :o]])
;; :x
