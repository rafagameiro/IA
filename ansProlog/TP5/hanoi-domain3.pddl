(define (domain hanoi)
  (:predicates (clear ?x) (smaller ?x ?y) (on ?x ?y) (disk ?x))
  (:action move-to
	   :parameters (?x ?y ?z) 
	   :precondition (and (clear ?x) (clear ?y) (on ?x ?z) (smaller ?x ?y) (disk ?x))
	   :effect (and (on ?x ?y) (clear ?z) (not (clear ?y)))))