import SwiftUI

struct ContentView: View {
    @State private var shouldOpenAbout = false

    var body: some View {
        NavigationStack {
            RemindersView()
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle")
                                .labelStyle(.titleAndIcon)
                        }
                        .accessibilityIdentifier("aboutButton")
                        .popover(isPresented: $shouldOpenAbout) {
                            AboutView()
                        }
                    }
                }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
