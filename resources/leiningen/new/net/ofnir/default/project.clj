(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/christoph-frick/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.clojure/test.check "1.1.1"]]
  :profiles {:kaocha {:dependencies [[lambdaisland/kaocha "1.60.977"]]}}
  :aliases {"test-refresh" ["kaocha" "--watch"]
            "kaocha" ["with-profile" "+kaocha" "run" "-m" "kaocha.runner"]}
  :global-vars {*warn-on-reflection* true
                *unchecked-math* true})
