(ns leiningen.new.base
  (:require [leiningen.new.templates :refer [renderer year date project-name ->files sanitize-ns name-to-path multi-segment]]
            [leiningen.core.main :as main]))

(defn base
  [name]
  (let [render (renderer "base")
        main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)
              :year (year)
              :date (date)}]
    (main/info "Generating a project called" name "based on a modified 'default' template.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["tests.edn" (render "tests.edn" data)]
             ["src/{{nested-dirs}}.clj" (render "core.clj" data)]
             ["test/{{nested-dirs}}_test.clj" (render "test.clj" data)]
             ["LICENSE" (render "LICENSE" data)]
             "resources")))
