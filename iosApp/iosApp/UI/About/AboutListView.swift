//
//  AboutListView.swift
//  iosApp
//
//  Created by Otamurod Safarov on 15/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Shared
import SwiftUI

struct AboutListView: View {
    let items: [AboutViewModel.RowItem]
    let footer: String

    var body: some View {
        List {
            Section {
                ForEach(items, id: \.self) { item in
                    VStack(alignment: .leading) {
                        Text(item.title)
                            .font(.footnote)
                            .foregroundStyle(.secondary)
                        Text(item.subtitle)
                            .font(.body)
                            .foregroundStyle(.primary)
                    }
                    .padding(.vertical, 4)
                }
            } footer: {
                Text(footer).font(.caption2)
            }
        }
    }
}

#Preview {
    AboutListView(items: [AboutViewModel.RowItem(title: "Title", subtitle: "Subtitle")], footer: "Section Footer")
}
